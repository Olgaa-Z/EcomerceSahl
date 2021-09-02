package com.yana.sahlhouseware.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.yana.sahlhouseware.R
import com.yana.sahlhouseware.datarobopojo.ResponseLogin
import com.yana.sahlhouseware.datarobopojo.ResponseRegister
import com.yana.sahlhouseware.retrofit.API
import com.yana.sahlhouseware.retrofit.ConfigurationRetro
import kotlinx.android.synthetic.main.activity_register.*
import retrofit2.Call
import retrofit2.Response

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        btnregister.setOnClickListener(){
            if (txtnama.text.toString().isEmpty()){
                txtnama.error ="Masukkan nama dulu"
                txtnama.requestFocus()
                return@setOnClickListener
            }else if(txtpassword.text.toString().isEmpty()){
                txtpassword.error="Masukkan password anda"
                txtpassword.requestFocus()
                return@setOnClickListener
            }else if(txtconfirmpassword.text.toString().isEmpty()){
                txtconfirmpassword.error="masukkan konfirmasi password anda"
                txtconfirmpassword.requestFocus()
                return@setOnClickListener
            }else if(txtpassword.text.toString() != txtconfirmpassword.text.toString()){
                Toast.makeText(this, "Password anda tidak sama!",Toast.LENGTH_SHORT).show()
            }else{
                doRegiser(txtnama.text.toString(),txtusername.text.toString(),txtpassword.text.toString())
            }
        }
    }

    fun doRegiser(namauser:String, username:String,password:String){
        //proses register
        val retrofit = ConfigurationRetro.instance
        val api = retrofit.create(API::class.java)

        api.register(namauser,username,password).enqueue(object:retrofit2.Callback<ResponseRegister>{
            override fun onResponse(
                call: Call<ResponseRegister>,
                response: Response<ResponseRegister>
            ) {
                if(response.isSuccessful){
                    Toast.makeText(applicationContext,response.message(), Toast.LENGTH_SHORT).show()
                }else{
                    Toast.makeText(applicationContext,response.message(), Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<ResponseRegister>, t: Throwable) {
                Toast.makeText(this@Register,t.message,Toast.LENGTH_SHORT).show()
            }

        })

    }


}