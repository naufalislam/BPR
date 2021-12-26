package com.coba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.core.content.ContentProviderCompat.requireContext
import com.coba.R
import com.coba.adapter.UserAdapter
import com.coba.data.UpdateDataResponse
import com.coba.model.UserModel
import com.coba.network.ApiService
import com.coba.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private lateinit var userAdapter : UserAdapter
    private var id : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        id =SharedPrefManager.getInstance(applicationContext).data.id
        val nama : EditText = findViewById(R.id.namapelamar)
        val ttl : EditText = findViewById(R.id.tempattanggallahir)
        val posisi : EditText = findViewById(R.id.posisiyangdilamar)
        val simpan = findViewById<CardView>(R.id.simpan)

        simpan.setOnClickListener {
            val Ednama = nama.text.toString().trim()
            val Edttl = ttl.text.toString().trim()
            val Edposisi = posisi.text.toString().trim()

            ApiService.instance.UpdateUser(id,Ednama,Edttl,Edposisi)
                    .enqueue(object : Callback<UpdateDataResponse> {
                        override fun onResponse(call: Call<UpdateDataResponse>, response: Response<UpdateDataResponse>) {
                            if (response.isSuccessful){
                                val intent = Intent(applicationContext, KaryawanActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                                Toast.makeText(applicationContext,"Anda Berhasil Menyampan Data", Toast.LENGTH_LONG)
                            }
                        }

                        override fun onFailure(call: Call<UpdateDataResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, "Tidak Bisa Menyimpan Data", Toast.LENGTH_SHORT).show()
                        }

                    })

        }


        }


}