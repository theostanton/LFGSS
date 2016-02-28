package com.theostanton.lfgss.listitem

import com.hannesdorfmann.mosby.mvp.MvpBasePresenter
import rx.Subscription
import timber.log.Timber

/**
 * Created by theostanton on 22/02/16.
 */
abstract class ListItemPresenter : MvpBasePresenter<ListItemView>() {
    var subscription : Subscription? = null
    open fun load(){
        view?.showLoading(true)
    }
    open fun more(currNumberOfItems:Int){

    }

    fun onError(throwable:Throwable){
        Timber.e("onError ${throwable.message}", throwable)
        view?.onError(throwable)
        view?.showLoading(false)
    }

    fun setData(items: List<ListItem>){
        Timber.d("onComplete $items")
        view?.showLoading(false)
        view?.setData(items)
    }

    override fun detachView(retainInstance: Boolean) {
        cancelIfRunning()
        super.detachView(retainInstance)
    }

    fun cancelIfRunning(){
        subscription?.unsubscribe()
    }
}