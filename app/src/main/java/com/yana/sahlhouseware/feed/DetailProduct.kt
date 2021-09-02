package com.yana.sahlhouseware.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.DataItem
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_detail_product.*

class DetailProduct : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_product)

        val datadetail = intent.getSerializableExtra("detail") as? DataItem

        detailnamaproduct.text=  datadetail?.namaProductAnd
        detailhargaproduct.text = datadetail?.hargaProductAnd
        detaildeskripsiproduct.text= datadetail?.descProductAnd
        detailstock.text= datadetail?.stockProductAnd
        Glide.with(this).load(ConfigurationRetro.url_gambar+ datadetail?.gambarProductAnd)
            .into(detailgambarproduct)

//
    }
}