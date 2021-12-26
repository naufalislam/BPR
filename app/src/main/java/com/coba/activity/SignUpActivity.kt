package com.coba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.coba.R
import com.coba.network.ApiService
import com.coba.data.SignUpResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)


        val buttonSignUp = findViewById<CardView>(R.id.signup)
        val txtemail = findViewById<EditText>(R.id.email)
        val txtpassword = findViewById<EditText>(R.id.password)


        buttonSignUp.setOnClickListener {
        val Email = txtemail.text.toString().trim()
        val Password = txtpassword.text.toString().trim()

        if (Email.isEmpty()){
            txtemail.error = "Email tidak boleh kosong"
            txtemail.requestFocus()
            return@setOnClickListener
        }
        if (Password.isEmpty()){
            txtpassword.error = "Password tidak boleh kosong"
            txtpassword.requestFocus()
            return@setOnClickListener
        }


            ApiService.instance.SignUp(Email, Password)
                    .enqueue(object : Callback<SignUpResponse> {
                        override fun onResponse(call: Call<SignUpResponse>, response: Response<SignUpResponse>) {
//                            Toast.makeText(applicationContext, "anjog mene", Toast.LENGTH_SHORT).show()
                            if (response.isSuccessful) {
                                Toast.makeText(applicationContext, "Anda Berhasil Mendaftar", Toast.LENGTH_LONG)
                                val intent = Intent(applicationContext, LoginActivity::class.java)
                                startActivity(intent)
                            }
                        }

                        override fun onFailure(call: Call<SignUpResponse>, t: Throwable) {
                            Toast.makeText(applicationContext, "Tidak Bisa Mendaftar", Toast.LENGTH_LONG)
                        }

                    })



        }
    }
}