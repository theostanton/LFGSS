package com.theostanton.lfgss.listitem.viewholder

import android.view.View
import android.widget.TextView
import com.theostanton.lfgss.R
import com.theostanton.lfgss.category.CatActivity
import com.theostanton.lfgss.global.ago
import com.theostanton.lfgss.home.Microcosm
import com.theostanton.lfgss.listitem.ListItem
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity

/**
 * Created by theostanton on 22/02/16.
 */
class MicrocosmViewHolder(itemView: View) : ListItemViewHolder(itemView){

    val root = itemView.findViewById(R.id.root)
    val titleTextView = itemView.findViewById(R.id.title_textView) as TextView
    val postedByTextView = itemView.findViewById(R.id.posted_by_textView) as TextView
    val postedAgoTextView = itemView.findViewById(R.id.posted_ago_textView) as TextView
    val repliedByTextView = itemView.findViewById(R.id.replied_by_textView) as TextView
    val repliedAgoTextView = itemView.findViewById(R.id.replied_ago_textView) as TextView
    val commentsCountTextView = itemView.findViewById(R.id.comments_count_textView) as TextView
    val conversationsCountTextView = itemView.findViewById(R.id.conversations_count_textView) as TextView

    override fun setItem(listItem: ListItem) {
        super.setItem(listItem)
        if(listItem is Microcosm){
            titleTextView.text = listItem.title
            postedByTextView.text = listItem.meta.createdBy?.profileName
            postedAgoTextView.text = listItem.meta.created?.ago()
//            repliedAgoTextView.text = listItem.lastComment.created?.ago()
//            repliedByTextView.text = listItem.lastComment.createdBy?.profileName

            commentsCountTextView.text = listItem.totalComments.toString()
            conversationsCountTextView.text = listItem.totalItems.toString()


            root.onClick {
                root.context.startActivity<CatActivity>("id" to listItem.id,"title" to listItem.title)
            }
        }
    }
}