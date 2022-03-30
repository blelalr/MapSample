package com.esther.mapsample.viewmodel

import androidx.databinding.BaseObservable
import com.esther.mapsample.R
import com.esther.mapsample.model.Step

class OthersViewModel(val step: Step) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_others_item
    override val viewType: Int = MainViewModel.STEP_OTHERS_ITEM
}