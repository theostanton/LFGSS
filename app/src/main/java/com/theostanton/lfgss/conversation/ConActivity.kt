package com.theostanton.lfgss.conversation

import android.os.Bundle
import com.theostanton.lfgss.listitem.ListItemActivity
import kotlinx.android.synthetic.main.activity_listitem.*

/**
 * Created by theostanton on 22/02/16.
 */
class ConActivity : ListItemActivity() {

    override val fromBottom = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        recyclerView.setupMoreListener(
                {
                    numberOfItems,numberBefore,currPos->
                    recyclerView.removeMoreListener()
                    (presenter as ConversationPresenter).more(numberOfItems)
                },10)

    }

    override fun createPresenter() = ConversationPresenter(intent.getIntExtra("id",0),intent.getIntExtra("totalComments",-1))
}