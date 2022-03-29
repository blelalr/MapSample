package com.esther.mapsample.view.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.esther.mapsample.databinding.FragmentTransitDialogListDialogStepBinding

class StepAdapter constructor(private val mItemCount: Int) :
    RecyclerView.Adapter<StepViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {

        return StepViewHolder(
            FragmentTransitDialogListDialogStepBinding.inflate(
                LayoutInflater.from(
                    parent.context
                ), parent, false
            )
        )

    }

    override fun onBindViewHolder(holder:StepViewHolder, position: Int) {
        holder.text.text = position.toString()
        Log.d("test", "$position")
    }

    override fun getItemCount(): Int {
        return mItemCount
    }
}

class StepViewHolder constructor(binding: FragmentTransitDialogListDialogStepBinding) :
    RecyclerView.ViewHolder(binding.root) {

    val text: TextView = binding.text
}

