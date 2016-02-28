package com.theostanton.lfgss.listitem

import com.google.gson.*
import java.lang.reflect.Type

/**
 * Created by theostanton on 22/02/16.
 */
class ListItemDeserialiser : JsonSerializer<ListItem>, JsonDeserializer<ListItem>{

    override fun serialize(p0: ListItem?, p1: Type?, p2: JsonSerializationContext?): JsonElement? {
        throw UnsupportedOperationException()
    }

    override fun deserialize(element: JsonElement?, type: Type?, context: JsonDeserializationContext?): ListItem? {
        val el = element?.asJsonObject
        return null
    }
}