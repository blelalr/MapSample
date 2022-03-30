package com.esther.mapsample.viewmodel

import androidx.databinding.BaseObservable
import com.esther.mapsample.R
import com.esther.mapsample.model.Transit

class DepartureViewModel(val transit: Transit) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_departure_item
    override val viewType: Int = MainViewModel.DEPARTURE_ITEM
}