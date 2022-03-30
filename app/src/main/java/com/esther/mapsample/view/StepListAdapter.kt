package com.esther.mapsample.view//package com.esther.mapsample.view.adapter
//
//import android.view.LayoutInflater
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.DiffUtil
//import androidx.recyclerview.widget.ListAdapter
//import androidx.recyclerview.widget.RecyclerView
//import com.esther.mapsample.model.Step
//
//class StepListAdapter constructor(private val mItemCount: Int) :
//    ListAdapter<Step, StepViewHolder>(StepDiffCallback()) {
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StepViewHolder {
//        return StepViewHolder.from(parent)
//
//    }
//
//    override fun onBindViewHolder(holder:StepViewHolder, position: Int) {
////        holder.bind(getItem(position))
//
//    }
//
//    override fun getItemCount(): Int {
//        return mItemCount
//    }
//}
//
//class StepDiffCallback: DiffUtil.ItemCallback<Step>(){
//    override fun areItemsTheSame(oldItem: Step, newItem: Step): Boolean {
//        return oldItem == newItem
//    }
//
//    override fun areContentsTheSame(oldItem: Step, newItem: Step): Boolean {
//        return oldItem == newItem
//    }
//
//}
//
//class StepViewHolder (private val binding: StepItemViewBinding) :
//    RecyclerView.ViewHolder(binding.root) {
//
//    val text: TextView = binding.text
//
//    fun bind(position: Int) {
//        binding.text.text = position.toString();
//    }
//
//    companion object {
//        fun from(parent: ViewGroup): StepViewHolder {
//            val layoutInflater = LayoutInflater.from(parent.context)
//            val binding = StepItemViewBinding.inflate(layoutInflater, parent, false)
//            return StepViewHolder(binding)
//        }
//    }
//}
//
