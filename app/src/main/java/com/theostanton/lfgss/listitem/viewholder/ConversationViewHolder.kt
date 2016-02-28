package com.theostanton.lfgss.listitem.viewholder

import android.view.View
import android.widget.TextView
import com.theostanton.lfgss.R
import com.theostanton.lfgss.api.get.Conversation
import com.theostanton.lfgss.conversation.ConActivity
import com.theostanton.lfgss.global.ago
import com.theostanton.lfgss.global.prettify
import com.theostanton.lfgss.listitem.ListItem
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity

/**
 * Created by theostanton on 22/02/16.
 */
class ConversationViewHolder(itemView: View) : ListItemViewHolder(itemView) {

    val root = itemView.findViewById(R.id.root)
    val titleTextView = itemView.findViewById(R.id.title_textView) as TextView
    val postedByTextView = itemView.findViewById(R.id.posted_by_textView) as TextView
    val postedAgoTextView = itemView.findViewById(R.id.posted_ago_textView) as TextView
    val repliedByTextView = itemView.findViewById(R.id.replied_by_textView) as TextView
    val repliedAgoTextView = itemView.findViewById(R.id.replied_ago_textView) as TextView
    val commentsCountTextView = itemView.findViewById(R.id.comments_count_textView) as TextView
    val viewsCountTextView = itemView.findViewById(R.id.views_count_textView) as TextView

    override fun setItem(item: ListItem) {
        super.setItem(item)
        if(item is Conversation){
            titleTextView.text = item.title
            postedByTextView.text = item.meta.createdBy?.profileName
            postedAgoTextView.text = item.meta.created?.ago()
            repliedAgoTextView.text = item.lastComment.created?.ago()

            repliedByTextView.text = item.lastComment.createdBy?.profileName
            commentsCountTextView.text = item.totalComments.prettify()
            viewsCountTextView.text = item.totalViews.prettify()


            root.onClick {
                root.context.startActivity<ConActivity>(
                        "id" to item.id,
                        "totalComments" to item.totalComments,
                        "title" to item.title
                )
            }
        }
    }
}