package com.theostanton.lfgss.listitem.viewholder

import android.text.Html
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import com.theostanton.lfgss.R
import com.theostanton.lfgss.api.get.Comment
import com.theostanton.lfgss.global.PicassoImageGetter
import com.theostanton.lfgss.global.ago
import com.theostanton.lfgss.listitem.ListItem

/**
 * Created by theostanton on 22/02/16.
 */
class CommentViewHolder(itemView: View) : ListItemViewHolder(itemView) {

    val userTextView = itemView.findViewById(R.id.user_textView) as TextView
    val commentTextView = itemView.findViewById(R.id.comment_textView) as TextView
    val avatarImageView = itemView.findViewById(R.id.avatar_imageview) as ImageView
    val agoTextView = itemView.findViewById(R.id.ago_textView) as TextView

    override fun setItem(listItem: ListItem) {
        super.setItem(listItem)
        if (listItem is Comment) {
            userTextView.text = listItem.meta.createdBy?.profileName
            commentTextView.text = Html.fromHtml(
                    listItem.html,
                    PicassoImageGetter(
                            commentTextView,
                            commentTextView.resources,
                            Picasso.with(commentTextView.context)
                    ),
                    null
            )
            commentTextView.movementMethod = LinkMovementMethod.getInstance()

            agoTextView.text = listItem.meta.created?.ago()
            Picasso.with(avatarImageView.context)
                    .load(listItem.meta.createdBy?.avatar)
                    .fit().centerCrop()
                    .into(avatarImageView)
        }
    }
}