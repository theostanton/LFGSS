package com.theostanton.lfgss.api.get

import com.theostanton.lfgss.listitem.ListItem
import java.util.*

/**
 * Created by theostanton on 22/02/16.
 */

class HuddlesGet(val data:Data){
    class Data(val huddles:Huddles){
        class Huddles(val items:List<Huddle>){

        }
    }
}
class HuddleGet(val data:Data){
    class Data(val comments: Comments)
}

class Huddle(
        val id:String,
        val title:String,
        val totalComments:Int,
        val meta:Meta
): ListItem(){
    override fun getType() = HUDDLE
}

class ConversationGet(val status: Int, val data: Data) {
    class Data(val comments: Comments
    ) {

    }
}

class Comments(val items: ArrayList<Comment>,
               val total:Int,
               val offset:Int,
               val totalPages:Int,
               val maxOffset:Int,
               val page:Int)

class Comment(
        val html: String,
        val meta: Meta
) : ListItem(){
    override fun getType() = COMMENT

    override fun toString() = "Comment[html=${html.substring(0,Math.min(html.lastIndex,10))}... type=${getType()}]"
    override fun equals(other: Any?): Boolean{
        if (this === other) return true
        if (other?.javaClass != javaClass) return false

        other as Comment

        if (html != other.html) return false
        if (meta != other.meta) return false

        return true
    }

    override fun hashCode(): Int{
        var result = html.hashCode()
        result += 31 * result + meta.hashCode()
        return result
    }


}
