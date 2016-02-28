package com.theostanton.lfgss.api

import android.content.Context
import com.theostanton.lfgss.api.adapters.RxJavaCallAdapterFactory
import com.theostanton.lfgss.listitem.BuildGson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import timber.log.Timber

/**
 * Created by theostanton on 21/02/16.
 */



object LFGSS {

    var accToken = ""

    fun init(ctx: Context) {

        val client = OkHttpClient().newBuilder().addInterceptor {
            Timber.d(it.request().url().toString())
            it.proceed(it.request())
            it.proceed(it.request().newBuilder()
                    .addHeader("Authorization",
                            " Bearer $accToken").build()
            )
        }.build()

        val builder = Retrofit.Builder()
        val retrofit = builder
                .baseUrl("https://lfgss.microco.sm/api/v1/")
                .client(client)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(BuildGson.getGson()))
                .build()

        api = retrofit.create(LFGSSAPI::class.java)
    }

    lateinit var api : LFGSSAPI



}