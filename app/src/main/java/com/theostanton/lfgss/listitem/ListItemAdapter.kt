package com.theostanton.lfgss.listitem

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.theostanton.lfgss.listitem.viewholder.ListItemViewHolder
import java.util.*

/**
 * Created by theostanton on 22/02/16.
 */
class ListItemAdapter : RecyclerView.Adapter<ListItemViewHolder>() {

    val listItems = ArrayList<ListItem>()

    override fun onBindViewHolder(holder: ListItemViewHolder?, position: Int) {
        holder?.setItem(listItems[position])
    }

    override fun getItemViewType(position: Int) = listItems[position].getType()

    override fun getItemCount() = listItems.size

    override fun onCreateViewHolder(parent: ViewGroup?, type: Int) = type.getViewHolder(parent)

    override fun getItemId(position: Int) = listItems[position].hashCode().toLong()

    fun set(items: List<ListItem>) {
        listItems.clear()
        listItems.addAll(items)
        notifyDataSetChanged()
    }

    fun add(items: List<ListItem>) {
        listItems.addAll(items)
        notifyDataSetChanged()
    }
}