package com.coba.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.cardview.widget.CardView
import com.coba.R
import com.coba.data.LoginResponse
import com.coba.network.ApiService
import com.coba.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_activiy)


        val buttonLogin = findViewById<CardView>(R.id.btn_login)
        val buttonSignUp = findViewById<CardView>(R.id.btn_signup)

        val email = findViewById<EditText>(R.id.txt_email)
        val password = findViewById<EditText>(R.id.txt_password)

        buttonLogin.setOnClickListener {

            val EdEmail = email.text.toString().trim()
            val EdPassword = password.text.toString().trim()

            if (EdEmail.isEmpty()){
                email.error = "Email tidak boleh kosong"
                email.requestFocus()
                return@setOnClickListener
            }
            if (EdPassword.isEmpty()){
                password.error = "Password tidak boleh kosong"
                password. requestFocus()
                return@setOnClickListener
            }

            ApiService.instance.Login(EdEmail, EdPassword)
                .enqueue(object : Callback<LoginResponse> {
                    override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                        if(response.isSuccessful){
                            SharedPrefManager.getInstance(applicationContext).saveUser(response.body()?.data!!)
                            val intent = Intent(applicationContext, KaryawanActivity::class.java)
                            startActivity(intent)
                        }
//                        if(response.body()?.data?.role == "admin"){
//                                val intent = Intent(applicationContext, AdminActivity::class.java)
//                                startActivity(intent)
//                                Toast.makeText(applicationContext,"Anda Berhasil Login Sebagai Admin", Toast.LENGTH_LONG)
//                            }
//
//                        if(response.body()?.data?.role == "karyawan"){
//                            val intent = Intent(applicationContext, KaryawanActivity::class.java)
//                            startActivity(intent)
//                            Toast.makeText(applicationContext,"Anda Berhasil Login Sebagai Karyawan", Toast.LENGTH_LONG)
//                        }
//                        Toast.makeText(applicationContext,"Terjadi Kesalahan Login", Toast.LENGTH_LONG)
                    }

                    override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                        Toast.makeText(applicationContext, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }

                })




        }

        buttonSignUp.setOnClickListener {
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onStart() {
        super.onStart()
        if(SharedPrefManager.getInstance(this).isLoggedIn){
            val intent = Intent(applicationContext, KaryawanActivity::class.java)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
            startActivity(intent)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return super.onSupportNavigateUp()
    }
}