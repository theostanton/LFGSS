package com.theostanton.lfgss.listitem

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.theostanton.lfgss.R
import com.theostanton.lfgss.base.MVPBaseActivity
import com.theostanton.lfgss.huddles.HuddlesActivity
import kotlinx.android.synthetic.main.activity_listitem.*
import kotlinx.android.synthetic.main.include_toolbar.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

/**
 * Created by theostanton on 22/02/16.
 */
abstract class ListItemActivity : MVPBaseActivity<ListItemView, ListItemPresenter>(), ListItemView {

    val adapter = ListItemAdapter().apply { setHasStableIds(true) }

    abstract val fromBottom:Boolean

    open fun populateToolbar(){
        title_textView.text = intent.getStringExtra("title")
    }

    override fun showLoading(visible: Boolean) {
//        if(visible)recyclerView.showProgress()
//        else recyclerView.hideProgress()
    }

    override fun onError(throwable: Throwable) {
        throwable.message?.apply {
            toast(this)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listitem)
        populateToolbar()
        back_button.onClick { onBackPressed() }
        huddles_button.onClick { startActivity<HuddlesActivity>() }
        recyclerView.recyclerView.layoutManager = LinearLayoutManager(this).apply { reverseLayout = fromBottom }
        recyclerView.adapter = adapter
        presenter.load()
    }

    override fun setData(items: List<ListItem>) {
        adapter.set(if(fromBottom)items.reversed() else items)
    }

    override fun addData(items: List<ListItem>,canGetMore:Boolean) {
        adapter.add(if(fromBottom)items.reversed() else items)
        if(canGetMore) {
            recyclerView.setupMoreListener(
                    {
                        numberOfItems,numberBefore,currPos->
                        recyclerView.removeMoreListener()
                        presenter.more(numberOfItems)
                    },10)
        }
    }
}