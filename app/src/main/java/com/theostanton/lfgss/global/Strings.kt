package com.theostanton.lfgss.global

import android.text.format.DateUtils
import org.joda.time.DateTime

/**
 * Created by theostanton on 22/02/16.
 */

fun String.ago() : String{
    val dateTime = DateTime(this)
    return DateUtils.getRelativeTimeSpanString(dateTime.millis).toString()
}