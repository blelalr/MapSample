package com.esther.mapsample.viewmodel

import android.app.Application
import android.graphics.Color
import android.util.Log
import androidx.lifecycle.*
import com.esther.mapsample.R
import com.esther.mapsample.model.Step
import com.esther.mapsample.model.Transit
import com.esther.mapsample.model.TransitMockData
import com.esther.mapsample.util.TransitMode
import com.esther.mapsample.util.UnitConverter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class MainViewModel @Inject constructor(
    private val transitMockData: TransitMockData,
    application: Application
) : AndroidViewModel(application) {
    val transit: LiveData<Transit>
        get() = _transit
    private val _transit = MutableLiveData<Transit>()

    val stepList: LiveData<List<StepViewModel>>
        get() = _stepList
    private val _stepList = MutableLiveData<List<StepViewModel>>()

    init {
        loadData()
    }

    private fun getResString(res: Int): String {
        return getApplication<Application>().resources.getString(res)
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
                    val hint: String = String.format(
                        getResString(R.string.others_hint),
                        UnitConverter.unitTimeToMin(step.arrive)
                    )
                    val lineColor = Color.parseColor(step.stepsDetail.first().line.color)
                    viewData.add(OthersViewModel(step, hint, lineColor))
                }
                TransitMode.Walk -> {
                    val hint: String = String.format(
                        getResString(R.string.walk_hint),
                        UnitConverter.sceToMin(step.estimatedTime),
                        UnitConverter.meterToMiles(step.distance)
                    )
                    viewData.add(WalkViewModel(hint))
                }
                TransitMode.Driving,
                TransitMode.Cycling -> {
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