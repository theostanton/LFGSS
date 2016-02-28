package com.theostanton.lfgss

import android.os.Bundle
import com.theostanton.lfgss.base.BaseActivity
import com.theostanton.lfgss.home.HomeActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.onClick
import org.jetbrains.anko.startActivity
import timber.log.Timber

/**
 * Created by theostanton on 21/02/16.
 */
class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Timber.tag("MainActivity")

        button.onClick{
            startActivity<HomeActivity>()
        }
    }
}