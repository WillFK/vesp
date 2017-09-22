package com.demo.fk.vesp

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.item_view.view.*

class ItemView(context: Context, attributeSet: AttributeSet?) : LinearLayout(context, attributeSet) {

    constructor(context: Context): this(context,  null)

    init {
        val inflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        inflater.inflate(R.layout.item_view, this, true)
        id = View.generateViewId()
    }

    fun load(text: String) : ItemView {
        itemViewText.text = text
        return this
    }

}