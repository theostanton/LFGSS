package com.theostanton.lfgss.home

import com.theostanton.lfgss.api.get.Meta
import com.theostanton.lfgss.listitem.ListItem
import java.util.*

/**
 * Created by theostanton on 22/02/16.
 */
class HomeGet(val success:Int, val data:Data){
    class Data(val items:Items){
        class Items(val items:ArrayList<ListItem>)
    }
}

class Microcosm(
        val title:String,
        val id:Int,
        val description:String,
        val totalItems:Int,
        val totalComments:Int,
        val meta: Meta
) : ListItem(){
    override fun getType() = MICROCOSM
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Microcosm

        if (title != other.title) return false
        if (id != other.id) return false
        if (description != other.description) return false
        if (totalItems != other.totalItems) return false
        if (totalComments != other.totalComments) return false
        if (meta != other.meta) return false

        return true
    }

    override fun hashCode(): Int{
        var result = title.hashCode()
        result += 31 * result + id
        result += 31 * result + description.hashCode()
        result += 31 * result + totalItems
        result += 31 * result + totalComments
        result += 31 * result + meta.hashCode()
        return result
    }

    override fun toString() = "Microcosm[title=$title]"
}