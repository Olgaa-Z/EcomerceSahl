package com.yana.sahlhouseware.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yana.sahlhouseware.MainActivity
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.ResponseLogin
import com.yana.sahlhouseware.retrofit.API
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Response

class Login : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        buttonlogin.setOnClickListener(){
            val usern = "anisa"
            val pass= "12345"
//            ceklogin(txtusername.text.toString(),txtpassword.text.toString())
            ceklogin(usern,pass)
        }

    }

    fun ceklogin(username:String, password:String){
        ConfigurationRetro.instance.create(API::class.java).loginUser(username,password)
            .enqueue(object:retrofit2.Callback<ResponseLogin>{
                override fun onResponse(
                    call: Call<ResponseLogin>,
                    response: Response<ResponseLogin>
                ) {
                    if (response.isSuccessful){
                        val dataLogin = response.body()?.data
                        val main= Intent(this@Login,MainActivity::class.java)
                        startActivity(main)
                    }else{
                        Toast.makeText(this@Login, response.message(),Toast.LENGTH_SHORT).show()
                    }
                }

                override fun onFailure(call: Call<ResponseLogin>, t: Throwable) {
                    Toast.makeText(this@Login,"There's Something Wrong !",Toast.LENGTH_SHORT).show()
                }
            })
    }
}