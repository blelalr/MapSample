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
            val step = transit.steps.groupBy {
                it.mode
            }
            val viewData = createViewData(transit, step)
            _stepList.postValue(viewData)
        }
    }

    private fun createViewData(transit: Transit, stepByMode: Map<String, List<Step>>): List<StepViewModel> {
        val viewData = mutableListOf<StepViewModel>()
        stepByMode.keys.forEach {
            val steps = stepByMode[it]
            viewData.add(DepartureViewModel(transit))
            steps?.forEach { step: Step ->
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
        }

        return viewData
    }

    companion object {
        const val DEPARTURE_ITEM = 0
        const val STEP_WALK_ITEM = 1
        const val STEP_OTHERS_ITEM = 2
        const val DESTINATION_ITEM = 3
    }
}