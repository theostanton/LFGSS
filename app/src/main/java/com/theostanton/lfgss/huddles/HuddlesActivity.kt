package com.theostanton.lfgss.huddles

import android.view.View
import com.theostanton.lfgss.listitem.ListItemActivity
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * Created by theostanton on 28/02/16.
 */

class HuddlesActivity : ListItemActivity() {

    override fun createPresenter() = HuddlesPresenter()

    override val fromBottom = false

    override fun populateToolbar() {
        title_textView.text = "Messages"
        huddles_button.visibility = View.GONE
    }
}

