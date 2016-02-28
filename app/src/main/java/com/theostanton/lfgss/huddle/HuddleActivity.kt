package com.theostanton.lfgss.huddle

import android.view.View
import com.theostanton.lfgss.listitem.ListItemActivity
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * Created by theostanton on 28/02/16.
 */
class HuddleActivity : ListItemActivity() {

    override val fromBottom =  true

    override fun createPresenter() = HuddlePresenter(intent.getStringExtra("id"))

    override fun populateToolbar() {
        super.populateToolbar()
        huddles_button.visibility = View.GONE
    }

}