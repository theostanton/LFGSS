package com.theostanton.lfgss.global.recyclerview

import android.content.Context
import android.graphics.Canvas
import android.support.v7.widget.RecyclerView
import com.theostanton.lfgss.R

/**
 * Created by theostanton on 22/02/16.
 */
class Divider(ctx:Context) : RecyclerView.ItemDecoration() {

    val divider = ctx.resources.getDrawable(R.drawable.line_divider)

    override fun onDrawOver(canvas: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        val left = parent.paddingLeft
        val right = parent.paddingRight

        for(i in 0..parent.childCount-1){
            val child = parent.getChildAt(i)
            val params = child.layoutParams as RecyclerView.LayoutParams
            val top = child.bottom + params.bottomMargin
            val bottom = top + divider.intrinsicHeight

            divider.setBounds(left,top,right,bottom)
            divider.draw(canvas)
        }
    }
}