package com.theostanton.lfgss.category

import com.theostanton.lfgss.listitem.ListItemActivity

/**
 * Created by theostanton on 22/02/16.
 */
class CatActivity : ListItemActivity() {


    override val fromBottom = false

    override fun createPresenter() = CategoryPresenter(intent.getIntExtra("id",0))
}