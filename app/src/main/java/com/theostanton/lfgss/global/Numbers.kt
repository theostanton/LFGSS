package com.theostanton.lfgss.global

/**
 * Created by theostanton on 28/02/16.
 */
fun Int.prettify() = when {
    this > 1000000 -> "${this / 1000000}m"
    this > 1000 -> "${this / 1000}k"
    else -> this.toString()
}