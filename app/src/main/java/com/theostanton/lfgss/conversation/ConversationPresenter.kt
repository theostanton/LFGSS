package com.theostanton.lfgss.conversation

import com.theostanton.lfgss.api.LFGSS
import com.theostanton.lfgss.listitem.ListItemPresenter
import rx.android.schedulers.AndroidSchedulers
import rx.lang.kotlin.onError
import rx.schedulers.Schedulers
import timber.log.Timber

/**
 * Created by theostanton on 21/02/16.
 */
class ConversationPresenter(val id: Int, val totalComments: Int) : ListItemPresenter() {

    val LIMIT = 25

    var page = 0
    var total = 0
    var maxOffset = (Math.floor(totalComments / LIMIT.toDouble()) * LIMIT).toInt()
    var totalPages = 0

    init {
        Timber.tag("ConvserationPresenter")
    }

    override fun load() {
        super.load()
        Timber.d("load() maxOffset=$maxOffset")
        cancelIfRunning()
        subscription = LFGSS.api
                .getConversation(id, maxOffset)
                .onError {
                    onError(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    total = it.data.comments.total
                    page = it.data.comments.page
                    totalPages = it.data.comments.totalPages
                    Timber.d("onComplete load $it maxOffset=$maxOffset page=$page total=$total totalPages=$totalPages")
                    setData(it.data.comments.items)
                }, { Timber.e("error ${it.message}", it) }
                )
    }

    override fun more(currNumberOfItems: Int) {
        val useOffset = totalComments - currNumberOfItems - LIMIT
        Timber.d("more() useOffset=$useOffset currNumberOfItems=$currNumberOfItems")
        cancelIfRunning()
        subscription = LFGSS.api
                .getConversation(id, useOffset)
                .onError {
                    onError(it)
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    total = it.data.comments.total
                    page = it.data.comments.page
                    totalPages = it.data.comments.totalPages
                    Timber.d("onComplete more $it useOffset=$useOffset page=$page total=$total totalPages=$totalPages")
                    view?.addData(it.data.comments.items, true)
                }
    }

}