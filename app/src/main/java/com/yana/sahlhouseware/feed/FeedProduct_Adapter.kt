package com.yana.sahlhouseware.feed

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.DataItem
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_feed_product_adapter.view.*

class FeedProduct_Adapter(private var data : List<DataItem>,val listener : (DataItem)->Unit) :
    RecyclerView.Adapter<FeedProduct_Adapter.ViewHolder>() {

    private  var cont : Context? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): FeedProduct_Adapter.ViewHolder {
        val view = LayoutInflater.from(parent.context)
        val l = view.inflate(R.layout.activity_feed_product_adapter, null)
        return ViewHolder(l)
    }

    override fun onBindViewHolder(holder: FeedProduct_Adapter.ViewHolder, position: Int) {
       val dataitem = data[position]
        holder.namaProduct.text= dataitem.namaProductAnd
        holder.stokProduct.text=dataitem.stockProductAnd
        holder.hargaProduct.text=dataitem.hargaProductAnd
        holder.cvProduct.setOnClickListener(){
            listener(dataitem)
        }
        cont?.let {Glide.with(it).load(ConfigurationRetro.url_gambar + dataitem.gambarProductAnd)
            .into(holder.gambarProduct) }

    }

    override fun getItemCount(): Int {
        return data.size
    }

    class ViewHolder(item : View):RecyclerView.ViewHolder(item){
         val namaProduct = item.namabarang
         val stokProduct =item.stock
         val hargaProduct = item.harga
         val gambarProduct = item.gambarbarang
         val cvProduct : CardView = item.cvproduct
    }


}