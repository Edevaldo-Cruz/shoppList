package com.example.shoppinglist.model

data class Shopp(
    val product: String,
    val description: String,

    val concluded: Boolean? = false,

    val id: Int? = null,

    val onClick: ((Int?) -> Unit)? = null
)

