package com.example.tradeapp.Fragments

import android.app.Dialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout

import com.example.tradeapp.R
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BottomsheetFragment : BottomSheetDialogFragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = inflater.inflate(R.layout.layout_stock_bottomsheet, container, false)

    override fun onStart() {
        super.onStart()

        val bottomSheet = dialog?.findViewById<FrameLayout>(
            com.google.android.material.R.id.design_bottom_sheet
        )
        bottomSheet?.let {
            val behavior = BottomSheetBehavior.from(it)

            // Set the height = half of screen
            val layoutParams = it.layoutParams
            layoutParams.height = (resources.displayMetrics.heightPixels * 0.5).toInt()
            it.layoutParams = layoutParams

            // Prevent expanding to full screen
            behavior.isFitToContents = false
            behavior.halfExpandedRatio = 0.5f  // exactly half
            behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED

            // 🔒 Lock max expansion
            behavior.skipCollapsed = true
            behavior.isDraggable = true  // can drag, but only inside scrolls
            behavior.addBottomSheetCallback(object : BottomSheetBehavior.BottomSheetCallback() {
                override fun onStateChanged(bottomSheet: View, newState: Int) {
                    if (newState == BottomSheetBehavior.STATE_EXPANDED) {
                        behavior.state = BottomSheetBehavior.STATE_HALF_EXPANDED
                    }
                }
                override fun onSlide(bottomSheet: View, slideOffset: Float) {}
            })
        }
    }


}