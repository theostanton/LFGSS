package com.theostanton.lfgss.huddles

import com.theostanton.lfgss.api.LFGSS
import com.theostanton.lfgss.listitem.ListItemPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by theostanton on 28/02/16.
 */

class HuddlesPresenter : ListItemPresenter() {

    init {
        Timber.tag("HuddlesPresenter")
    }

    override fun load() {
        super.load()
        cancelIfRunning()
        subscription = LFGSS.api
                .getHuddles()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        { setData(it.data.huddles.items) },
                        { Timber.e("error ${it.message}", it) }
                )
    }


}