package com.esther.mapsample.viewmodel

import androidx.databinding.BaseObservable
import com.esther.mapsample.R
import com.esther.mapsample.model.Transit

class DestinationViewModel(val destination: String) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_destination_item
    override val viewType: Int = MainViewModel.DESTINATION_ITEM
}