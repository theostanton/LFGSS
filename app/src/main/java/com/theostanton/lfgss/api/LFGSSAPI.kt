package com.theostanton.lfgss.api

import com.theostanton.lfgss.api.get.CategoryGet
import com.theostanton.lfgss.api.get.ConversationGet
import com.theostanton.lfgss.api.get.HuddleGet
import com.theostanton.lfgss.api.get.HuddlesGet
import com.theostanton.lfgss.api.post.AuthBody
import com.theostanton.lfgss.api.post.AuthPost
import com.theostanton.lfgss.home.HomeGet
import retrofit2.http.*
import rx.Observable

/**
 * Created by theostanton on 21/02/16.
 */

interface LFGSSAPI {

    @GET("microcosms")
    fun getHome(): Observable<HomeGet>

    @GET("microcosms/{category_id}")
    fun getCategory(
            @Path("category_id") categoryId : Int
    ): Observable<CategoryGet>

    @GET("huddles")
    fun getHuddles(
    ): Observable<HuddlesGet>

    @GET("huddles/{huddle_id}")
    fun getHuddle(
            @Path("huddle_id") id:String
    ): Observable<HuddleGet>

    @GET("conversations/{conversation_id}")
    fun getConversation(
            @Path("conversation_id") conversationId : Int,
            @Query("offset") offset:Int=0
    ): Observable<ConversationGet>

    @POST("/auth")
    fun auth(@Body body: AuthBody) : Observable<AuthPost>

}