package com.theostanton.lfgss.category

import com.theostanton.lfgss.api.LFGSS
import com.theostanton.lfgss.listitem.ListItemPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by theostanton on 21/02/16.
 */
class CategoryPresenter(val id:Int)  : ListItemPresenter() {

    init{
        Timber.tag("CategoryPresenter")
    }

    override fun load(){
        super.load()
        Timber.d("load()")
        cancelIfRunning()
        subscription = LFGSS.api
                .getCategory(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {setData(it.data.items.items)},
                        {Timber.e("error ${it.message}",it)}
                )
    }
}