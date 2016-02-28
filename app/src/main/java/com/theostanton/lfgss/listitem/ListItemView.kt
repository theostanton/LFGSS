package com.theostanton.lfgss.listitem

import com.hannesdorfmann.mosby.mvp.MvpView

/**
 * Created by theostanton on 22/02/16.
 */
interface ListItemView : MvpView {
    fun onError(throwable:Throwable)
    fun showLoading(visible:Boolean)
    fun setData(items:List<ListItem>)
    fun addData(items:List<ListItem>,canGetMore:Boolean=false)
}