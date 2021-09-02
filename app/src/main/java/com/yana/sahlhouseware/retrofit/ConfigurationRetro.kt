package com.yana.sahlhouseware.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object ConfigurationRetro {

    const val url_gambar= "http://192.168.18.5/Lauwba_ecommerse/assets/images/"
    private var retrofit:Retrofit?=null
    val instance :Retrofit
    get(){
        if (retrofit==null){
            retrofit = Retrofit.Builder()
            .baseUrl("http://192.168.18.5/Lauwba_ecommerse/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }
        return retrofit!!
    }

//    var retrofit = Retrofit.Builder()
//        .baseUrl("http://192.168.43.58/Lauwba_ecommerse/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

}