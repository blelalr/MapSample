package com.esther.mapsample.viewmodel

import android.graphics.Color
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.esther.mapsample.R
import com.esther.mapsample.model.Step

class OthersViewModel(val step: Step, val hint:String, @get:Bindable var lineColor: Int = Color.RED, val departureTime: String, val arriveTime: String) : BaseObservable(), StepViewModel {
    override val layoutId: Int = R.layout.step_others_item
    override val viewType: Int = MainViewModel.STEP_OTHERS_ITEM
}