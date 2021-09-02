package com.yana.sahlhouseware.feed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.DataItem
import com.yana.sahlhouseware.datarobopojo.ResponseProduct
import com.yana.sahlhouseware.retrofit.API
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_feed_product.*
import retrofit2.Call
import retrofit2.Response

class FeedProduct : Fragment() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_feed_product)
//
//        listDataproduct()
//    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_feed_product, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        listDataproduct()
    }

    fun listDataproduct(){
        ConfigurationRetro.instance.create(API::class.java).productAPI()
            .enqueue(object : retrofit2.Callback<ResponseProduct>{

                override fun onResponse(
                    call: Call<ResponseProduct>,
                    response: Response<ResponseProduct>
                ) {
                   if (response.isSuccessful){
                       val datait : List<DataItem?>? = response.body()?.data
                       if (response.body()?.status==1){
                           Toast.makeText(context, "no data found", Toast.LENGTH_SHORT).show()
                       }else{
                           val adapterproduct = FeedProduct_Adapter(datait as List<DataItem>){}
                           rvproduct.layoutManager = LinearLayoutManager(context)
                           rvproduct.adapter=adapterproduct

                       }

                   }
                }

                override fun onFailure(call: Call<ResponseProduct>, t: Throwable) {
                    Toast.makeText(context, "Connection Failed!", Toast.LENGTH_LONG).show()
                }

            })
    }
}