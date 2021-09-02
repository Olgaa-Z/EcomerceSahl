package com.yana.sahlhouseware.datarobopojo

import com.google.gson.annotations.SerializedName

data class ResponseLogin(

    @field:SerializedName("data")
    val data: List<DataItemLogin?>? = null,

    @field:SerializedName("code")
    val response: Int? = null,

    @field:SerializedName("message")
    val status: String? = null
)


data class DataItemLogin(

    @field:SerializedName("username")
    val Username: String? = null,

    @field:SerializedName("password")
    val Password: String? = null



)
