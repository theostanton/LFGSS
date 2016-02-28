package com.theostanton.lfgss.base

import android.app.Application
import com.crashlytics.android.Crashlytics
import com.theostanton.lfgss.api.LFGSS
import io.fabric.sdk.android.Fabric
import timber.log.Timber

/**
 * Created by theostanton on 21/02/16.
 */
class BaseApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Fabric.with(this,Crashlytics())
        Timber.plant(Timber.DebugTree())
        LFGSS.init(this)
    }

}