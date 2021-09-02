package com.yana.sahlhouseware.datarobopojo

import com.google.gson.annotations.SerializedName

data class ResponseRegister (

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("success")
    val success: Boolean? = null
)