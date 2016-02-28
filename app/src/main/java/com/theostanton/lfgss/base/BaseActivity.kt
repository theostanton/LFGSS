package com.theostanton.lfgss.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

/**
 * Created by theostanton on 21/02/16.
 */
open class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }

    override fun finish() {
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
        super.finish()
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out)
    }

}