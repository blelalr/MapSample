package com.esther.mapsample.viewmodel

import androidx.databinding.BaseObservable
import com.esther.mapsample.R
import com.esther.mapsample.model.Transit

class DestinationViewModel(val transit: Transit) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_item_view
    override val viewType: Int = MainViewModel.DESTINATION_ITEM
}