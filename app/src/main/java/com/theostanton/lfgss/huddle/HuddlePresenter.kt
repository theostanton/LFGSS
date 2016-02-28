package com.theostanton.lfgss.huddle

import com.theostanton.lfgss.api.LFGSS
import com.theostanton.lfgss.listitem.ListItemPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by theostanton on 28/02/16.
 */
class HuddlePresenter(val id:String) : ListItemPresenter() {

    override fun load() {
        super.load()
        subscription = LFGSS.api.getHuddle(id)
                .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
                .subscribe (
                        {setData(it.data.comments.items)},
                        { Timber.e("error ${it.message}",it)}
                )
    }

}