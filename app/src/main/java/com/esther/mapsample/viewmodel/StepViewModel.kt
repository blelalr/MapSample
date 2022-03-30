package com.esther.mapsample.viewmodel

import androidx.annotation.LayoutRes

interface StepViewModel {
    @get:LayoutRes
    val layoutId: Int
    val viewType: Int
        get() = 0
}