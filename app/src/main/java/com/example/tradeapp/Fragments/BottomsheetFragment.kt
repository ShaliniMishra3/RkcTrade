package com.example.tradeapp.Fragments

import android.content.res.Resources
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import com.example.tradeapp.R
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.bottomsheet.BottomSheetDialog


class BottomsheetFragment : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.layout_stock_bottomsheet, container, false)
    }
    override fun onStart() {
        super.onStart()
        val dialog = dialog as? BottomSheetDialog
        val bottomSheet = dialog?.findViewById<FrameLayout>(com.google.android.material.R.id.design_bottom_sheet)

        bottomSheet?.let {

            val behavior = BottomSheetBehavior.from(it)

            // Fix height in pixels (e.g., 400dp)
            val heightInPx = (400 * resources.displayMetrics.density).toInt()
            it.layoutParams.height = heightInPx
            it.requestLayout()

            behavior.peekHeight = heightInPx
            behavior.isFitToContents = false
            behavior.state = BottomSheetBehavior.STATE_COLLAPSED
        }
    }
}