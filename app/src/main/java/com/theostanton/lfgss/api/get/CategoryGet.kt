package com.theostanton.lfgss.api.get

import com.theostanton.lfgss.listitem.ListItem
import java.util.*

/**
 * Created by theostanton on 22/02/16.
 */
class CategoryGet(val status: Int, val data: Data) {
    class Data(val items: Items){
        class Items(val items:ArrayList<ListItem>)
    }
}


class Conversation(
        val title: String,
        val totalViews: Int,
        val totalComments: Int,
        val maxOffset: Int,
        val lastComment: Meta,
        val id: Int,
        val meta: Meta
) : ListItem(){
    override fun getType() = CONVERSATION

    override fun toString() = "Conversation[title=$title type=${getType()}]"

    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Conversation

        if (title != other.title) return false
        if (totalViews != other.totalViews) return false
        if (totalComments != other.totalComments) return false
        if (lastComment != other.lastComment) return false
        if (id != other.id) return false
        if (meta != other.meta) return false

        return true
    }
    override fun hashCode(): Int{
        var result = title.hashCode()
        result += 31 * result + totalViews
        result += 31 * result + totalComments
        result += 31 * result + lastComment.hashCode()
        result += 31 * result + id
        result += 31 * result + meta.hashCode()
        return result
    }


}