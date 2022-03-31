package com.esther.mapsample.view

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.esther.mapsample.viewmodel.StepViewModel

@BindingAdapter("stepViewModels")
fun bindstepViewModels(recyclerView: RecyclerView, stepViewModels: List<StepViewModel>?) {
    val adapter = getOrCreateAdapter(recyclerView)
    adapter.updateItems(stepViewModels)
}

private fun getOrCreateAdapter(recyclerView: RecyclerView): BindableRecyclerViewAdapter {
    return if (recyclerView.adapter != null && recyclerView.adapter is BindableRecyclerViewAdapter) {
        recyclerView.adapter as BindableRecyclerViewAdapter
    } else {
        val bindableRecyclerAdapter = BindableRecyclerViewAdapter()
        recyclerView.adapter = bindableRecyclerAdapter
        bindableRecyclerAdapter
    }
}