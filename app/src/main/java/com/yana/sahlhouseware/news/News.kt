package com.yana.sahlhouseware.news

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
import com.yana.sahlhouseware.datarobopojo.DataItemNews
import com.yana.sahlhouseware.datarobopojo.ResponseNews
import com.yana.sahlhouseware.retrofit.API
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_feed_product.*
import kotlinx.android.synthetic.main.activity_news.*
import retrofit2.Call
import retrofit2.Response

class News : Fragment() {

//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_news2)
//
//        apilistnews()
//    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_news2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        apilistnews()

    }


    fun apilistnews(){
        ConfigurationRetro.instance.create(API::class.java).newsAPI()
            .enqueue(object :retrofit2.Callback<ResponseNews>{
                override fun onResponse(
                    call: Call<ResponseNews>,
                    response: Response<ResponseNews>
                ) {
                    if (response.isSuccessful){
                        val datanews : List<DataItemNews?>? = response.body()?.data
                        if (response.body()?.status==1){
                            Toast.makeText(context, response.message(), Toast.LENGTH_SHORT).show()
                        }else{
                            val adapternews = NewsAdapter(datanews as List<DataItemNews>, context!!)
                            rvnews.layoutManager = LinearLayoutManager(context)
                            rvnews.adapter=adapternews
                        }
                    }

                }

                override fun onFailure(call: Call<ResponseNews>, t: Throwable) {
                    Toast.makeText(context,"there is no connection", Toast.LENGTH_LONG).show()
                }

            })
    }
}