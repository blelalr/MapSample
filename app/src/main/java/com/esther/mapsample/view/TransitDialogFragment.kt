package com.esther.mapsample.view

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.coordinatorlayout.widget.CoordinatorLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.esther.mapsample.databinding.FragmentTransitDialogListDialogBinding
import com.esther.mapsample.view.adapter.StepAdapter
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetBehavior.BottomSheetCallback
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

// TODO: Customize parameter argument names
const val ARG_ITEM_COUNT = "item_count"

/**
 *
 * A fragment that shows a list of items as a modal bottom sheet.
 *
 * You can show this modal bottom sheet from your activity like this:
 * <pre>
 *    TransitDialogFragment.newInstance(30).show(supportFragmentManager, "dialog")
 * </pre>
 */
class TransitDialogFragment : BottomSheetDialogFragment() {

    private var _binding: FragmentTransitDialogListDialogBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentTransitDialogListDialogBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.list.layoutManager =
            LinearLayoutManager(context)
        binding.list.adapter =
            arguments?.getInt(ARG_ITEM_COUNT)?.let {
                Log.d("esther", "$it")
                StepAdapter(it)
            }
    }

    companion object {
        fun newInstance(itemCount: Int): TransitDialogFragment =
            TransitDialogFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_ITEM_COUNT, itemCount)
                }
            }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}