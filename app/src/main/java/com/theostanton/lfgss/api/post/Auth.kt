package com.theostanton.lfgss.api.post

/**
 * Created by theostanton on 28/02/16.
 */


class AuthBody(val assertion:String, val ClientSecret:String)

class AuthPost(val status:Int, val data:String)