package com.esther.mapsample.view.step

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.esther.mapsample.MainViewModel
import com.esther.mapsample.databinding.FragmentStepBinding
import com.esther.mapsample.view.adapter.StepAdapter

const val ARG_ITEM_COUNT = "item_count"

class StepFragment : Fragment() {

    companion object {
        fun newInstance(itemCount: Int): StepFragment =
            StepFragment().apply {
                Log.d("test", "StepFragment newInstance")
                arguments = Bundle().apply {
                    putInt(ARG_ITEM_COUNT, itemCount)
                }
            }
    }

    private lateinit var viewModel: MainViewModel
    private var _binding: FragmentStepBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentStepBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.list.layoutManager =
            LinearLayoutManager(context)
        binding.list.adapter =
            arguments?.getInt(ARG_ITEM_COUNT)?.let {
                Log.d("test", "StepAdapter $it")
                StepAdapter(it)
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}