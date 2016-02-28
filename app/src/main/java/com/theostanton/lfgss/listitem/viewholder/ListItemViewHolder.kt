package com.theostanton.lfgss.listitem.viewholder

import android.support.v7.widget.RecyclerView
import android.view.View
import com.theostanton.lfgss.listitem.ListItem
import timber.log.Timber

/**
 * Created by theostanton on 22/02/16.
 */
open class ListItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    open fun setItem(listItem: ListItem){
        Timber.d("setItem $listItem")
    }

}