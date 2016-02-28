package com.theostanton.lfgss.api.get

/**
 * Created by theostanton on 21/02/16.
 */

class User(
        val id: Int,
        val profileName: String,
        val meta: Meta,
        val avatar: String
)

class Meta(
        val links: List<Link>?,
        val createdBy: User?,
        val created: String?
) {
    fun getSelf(): String? {
        links?.forEach {
            if (it.rel == "self") return it.href
        }
        return null
    }

}

class Link(
        val rel: String,
        val title: String,
        val href: String
)