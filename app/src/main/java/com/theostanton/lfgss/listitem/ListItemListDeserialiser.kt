package com.theostanton.lfgss.listitem

import com.google.gson.*
import com.theostanton.lfgss.api.get.Comment
import com.theostanton.lfgss.api.get.Conversation
import com.theostanton.lfgss.home.Microcosm
import timber.log.Timber
import java.lang.reflect.Type
import java.util.*

/**
 * Created by theostanton on 22/02/16.
 */

class ListItemListDeserialiser : JsonSerializer<ArrayList<out ListItem>>, JsonDeserializer<ArrayList<out ListItem>> {

    val gson by lazy {
        BuildGson.getGson()
    }

    override fun serialize(p0: ArrayList<out ListItem>?, p1: Type?, p2: JsonSerializationContext?): JsonElement? {
        throw UnsupportedOperationException()
    }

    override fun deserialize(element: JsonElement?, type: Type?, context: JsonDeserializationContext?): ArrayList<out ListItem>? {
        val jarr = element?.asJsonArray ?: return ArrayList()

        val list = ArrayList<ListItem>(jarr.size())

        var listItem: ListItem?
        var cls: Type?
        var jsonObj: JsonObject?

        for (el in jarr) {
            try {
                jsonObj = el.asJsonObject
                cls = jsonToClass(jsonObj)

                listItem = gson.fromJson(jsonObj.get("item"), cls)
                Timber.d("listItem=$listItem")
                if (listItem != null) list.add(listItem)
            } catch(ex: Exception) {
                Timber.e("deseriale exception ${ex.message}", ex)
                //                Toasts.d(ex.message)
            } catch(ex: IllegalStateException) {
                Timber.e("deseriale IllegalStateException ${ex.message}", ex)
                //                Toasts.d(ex.message)
            }
        }
        return list
    }

    fun jsonToClass(jsonObject: JsonObject): Type? {

        if (jsonObject.has("itemType")) {
            if (jsonObject.has("markdown")) return Comment::class.java
            when (jsonObject.get("itemType").asString) {
                "conversation" -> return Conversation::class.java
                "microcosm" -> return Microcosm::class.java
                "huddle" -> return Comment::class.java
            }
        }
        return null
    }
}