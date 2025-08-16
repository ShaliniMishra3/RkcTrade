package com.example.tradeapp

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class StockBottomSheet : BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.layout_stock_bottomsheet, container, false)
    }

    override fun onStart() {
        super.onStart()
        (dialog as? com.google.android.material.bottomsheet.BottomSheetDialog)
            ?.findViewById<View>(com.google.android.material.R.id.design_bottom_sheet)
            ?.background = ContextCompat.getDrawable(requireContext(), R.drawable.bg_bottomsheet_round)
    }
}

