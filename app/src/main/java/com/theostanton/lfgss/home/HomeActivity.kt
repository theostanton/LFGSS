package com.theostanton.lfgss.home

import android.view.View
import com.theostanton.lfgss.listitem.ListItemActivity
import kotlinx.android.synthetic.main.include_toolbar.*

/**
 * Created by theostanton on 22/02/16.
 */
class HomeActivity : ListItemActivity() {

    override val fromBottom = false

    override fun populateToolbar() {
        back_button.visibility = View.GONE
        title_textView.text = "LFGSS"
    }

    override fun createPresenter() = HomePresenter()
}