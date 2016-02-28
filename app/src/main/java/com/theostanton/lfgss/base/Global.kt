package com.theostanton.lfgss.base

import android.view.LayoutInflater
import android.view.ViewGroup

/**
 * Created by theostanton on 21/02/16.
 */

fun ViewGroup.inflate(res: Int) = LayoutInflater.from(context).inflate(res, this, false)
