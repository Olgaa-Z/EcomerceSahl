package com.yana.sahlhouseware.datarobopojo

import com.google.gson.annotations.SerializedName

data class ResponseNews(

	@field:SerializedName("data")
	val data: List<DataItemNews?>? = null,

	@field:SerializedName("response")
	val response: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

data class DataItemNews(

	@field:SerializedName("id_news")
	val idNews: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("author")
	val author: String? = null,

	@field:SerializedName("konten")
	val konten: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("added_on")
	val added_on: String? = null

)
