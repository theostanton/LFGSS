package com.theostanton.lfgss.home

import com.theostanton.lfgss.api.LFGSS
import com.theostanton.lfgss.listitem.ListItemPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.onError
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by theostanton on 22/02/16.
 */
class HomePresenter : ListItemPresenter() {

    init{
        Timber.tag("HomePresenter")
    }

    override fun load() {
        super.load()
        Timber.d("load()")
        cancelIfRunning()
        subscription = LFGSS.api
                .getHome()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .onError {
                    onError(it)
                }
                .subscribe {
                    setData(it.data.items.items)
                }
        }
}