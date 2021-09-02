package com.yana.sahlhouseware.news

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.DataItem
import com.yana.sahlhouseware.datarobopojo.DataItemNews
import com.yana.sahlhouseware.feed.FeedProduct_Adapter
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_feed_product_adapter.view.*
import kotlinx.android.synthetic.main.activity_news_adapter.view.*

class NewsAdapter(private var datanews : List<DataItemNews>, private var context : Context):
    RecyclerView.Adapter<NewsAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsAdapter.ViewHolder {
        val view = LayoutInflater.from(context)
        val l = view.inflate(R.layout.activity_news_adapter, null)
        return NewsAdapter.ViewHolder(l)
    }

    override fun onBindViewHolder(holdernews: NewsAdapter.ViewHolder, position: Int) {
        val dataitemnews = datanews.get(position)
        holdernews.judul.text= dataitemnews.judul
        holdernews.tanggal.text= dataitemnews.added_on
        holdernews.author.text= dataitemnews.author
        Glide.with(context).load(ConfigurationRetro.url_gambar + dataitemnews.gambar)
            .into(holdernews.gambar)


    }

    override fun getItemCount(): Int {
       return datanews.size
    }

    class ViewHolder(itemnews : View):RecyclerView.ViewHolder(itemnews){
        val judul = itemnews.judulnews
        val author = itemnews.authornews
        val tanggal = itemnews.tanggalnews
        val gambar = itemnews.gambarnews

    }




}