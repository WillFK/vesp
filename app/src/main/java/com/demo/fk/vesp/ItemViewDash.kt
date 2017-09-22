package com.demo.fk.vesp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_view_target.view.*

class ItemViewDash(context: Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet) {

    constructor(context: Context): this(context,  null)

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_view_dash, this, true)
        id = View.generateViewId()
    }
}