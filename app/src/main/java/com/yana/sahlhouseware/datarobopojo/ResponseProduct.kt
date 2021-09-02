package com.yana.sahlhouseware.datarobopojo

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

data class ResponseProduct(

	@field:SerializedName("data")
	val data: List<DataItem?>? = null,

	@field:SerializedName("response")
	val response: String? = null,

	@field:SerializedName("status")
	val status: Int? = null
)


data class DataItem(

	@field:SerializedName("id_productAnd")
	val idProductAnd: String? = null,

	@field:SerializedName("stock_productAnd")
	val stockProductAnd: String? = null,

	@field:SerializedName("nama_productAnd")
	val namaProductAnd: String? = null,

	@field:SerializedName("harga_productAnd")
	val hargaProductAnd: String? = null,

	@field:SerializedName("desc_productAnd")
	val descProductAnd: String? = null,

	@field:SerializedName("gambar_productAnd")
	val gambarProductAnd: String? = null

)
