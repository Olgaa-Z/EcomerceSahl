package com.yana.sahlhouseware.retrofit

import com.yana.sahlhouseware.datarobopojo.ResponseLogin
import com.yana.sahlhouseware.datarobopojo.ResponseNews
import com.yana.sahlhouseware.datarobopojo.ResponseProduct
import com.yana.sahlhouseware.datarobopojo.ResponseRegister
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface API {

    @GET("index.php/Api/product")
    fun productAPI():Call<ResponseProduct>

    @GET("index.php/API/news")
    fun newsAPI():Call<ResponseNews>

    @POST("index.php/Api/product")
    @FormUrlEncoded
    fun user():Call<ResponseProduct>

    @POST("index.php/Login/dataLogin")
    @FormUrlEncoded
    fun loginUser(
        @Field("username") username:String,
        @Field("password") password:String
    ):Call<ResponseLogin>

    @POST("index.php/Register/doRegister")
    @FormUrlEncoded
    fun register(
        @Field("nama_user") namauser:String,
        @Field("username") username:String,
        @Field("password") password:String
    ):Call<ResponseRegister>
}