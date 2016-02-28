package com.theostanton.lfgss.listitem

import android.view.LayoutInflater
import android.view.ViewGroup
import com.theostanton.lfgss.R
import com.theostanton.lfgss.listitem.viewholder.*

/**
 * Created by theostanton on 22/02/16.
 */

fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)

fun Int.getViewHolder(parent: ViewGroup?): ListItemViewHolder? {

    if (parent == null) return null

    fun getLayoutRes(): Int {
        when (this) {
            ListItem.COMMENT -> return R.layout.holder_comment
            ListItem.CONVERSATION -> return R.layout.holder_conversation
            ListItem.MICROCOSM -> return R.layout.holder_microcosm
            ListItem.HUDDLE -> return R.layout.holder_huddle
        }
        return -1
    }

    val itemView = parent.inflate(getLayoutRes())

    when (this) {
        ListItem.COMMENT -> return CommentViewHolder(itemView)
        ListItem.CONVERSATION -> return ConversationViewHolder(itemView)
        ListItem.MICROCOSM -> return MicrocosmViewHolder(itemView)
        ListItem.HUDDLE -> return HuddleViewHolder(itemView)
    }
    return null
}

open class ListItem() {

    companion object {
        const val COMMENT = 1
        const val CONVERSATION = 2
        const val MICROCOSM = 3
        const val HUDDLE = 4
    }

    open fun getType() = 0
}
