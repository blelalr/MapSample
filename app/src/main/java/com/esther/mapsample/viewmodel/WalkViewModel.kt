package com.esther.mapsample.viewmodel

import androidx.databinding.BaseObservable
import com.esther.mapsample.R
import com.esther.mapsample.model.Step

class WalkViewModel(val step: Step) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_walk_item
    override val viewType: Int = MainViewModel.STEP_WALK_ITEM
}