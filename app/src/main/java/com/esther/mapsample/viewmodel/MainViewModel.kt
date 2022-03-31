package com.esther.mapsample.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esther.mapsample.model.Step
import com.esther.mapsample.model.Transit
import com.esther.mapsample.model.TransitMockData
import com.esther.mapsample.util.TransitMode
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val transitMockData: TransitMockData
) : ViewModel() {
    val transit: LiveData<Transit>
        get() = _transit
    private val _transit = MutableLiveData<Transit>()

    val stepList: LiveData<List<StepViewModel>>
        get() = _stepList
    private val _stepList = MutableLiveData<List<StepViewModel>>()

    init {
        loadData()
    }

    private fun loadData() {
        viewModelScope.launch {
            val transit = transitMockData.getTransit()
            val viewData = createViewData(transit, transit.steps)
            _stepList.postValue(viewData)
        }
    }

    private fun createViewData(transit: Transit, steps: List<Step>): List<StepViewModel> {
        val viewData = mutableListOf<StepViewModel>()
        viewData.add(DepartureViewModel(transit.steps.first().originName))
        steps.forEach { step ->
            Log.d("test", "${step.mode}")
            when (TransitMode.from(step.mode)) {
                TransitMode.Train, TransitMode.Tram, TransitMode.Bus, TransitMode.Subway -> {
                    viewData.add(OthersViewModel(step))
                }
                TransitMode.Walk -> {
                    viewData.add(WalkViewModel(step))
                }
                TransitMode.Driving -> {
                    viewData.add(OthersViewModel(step))
                }
                TransitMode.Cycling -> {
                    viewData.add(OthersViewModel(step))
                }
            }
        }
        Log.d("test", "$transit")
        viewData.add(DestinationViewModel(transit.steps.last().destinationName))
        return viewData
    }

    companion object {
        const val DEPARTURE_ITEM = 0
        const val STEP_WALK_ITEM = 1
        const val STEP_OTHERS_ITEM = 2
        const val DESTINATION_ITEM = 3
    }
}