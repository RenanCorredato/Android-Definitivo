package com.renancorredato.recyclerview

data class User(
    val name: String,
    val id: Long,
    val lastName: String
) {
    val fullname: String get() = "$name $lastName #$id"
}