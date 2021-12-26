package com.coba.fragment

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.coba.R
import com.coba.activity.KaryawanActivity
import com.coba.data.TambahDataKaryawanResponse
import com.coba.network.ApiService
import com.coba.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class TambahDataKaryawanFragment : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_tambah_data_karyawan, container, false)
        val btnSimpan : Button = view.findViewById(R.id.btnSave)
        val txtpekerjaan : EditText = view.findViewById(R.id.txt_kerja)as EditText
        val txtpelatihan : EditText = view.findViewById(R.id.txt_pelatihan)as EditText

        btnSimpan.setOnClickListener {
            val id = SharedPrefManager.getInstance(requireContext()).data.id
            val pekerjaan = txtpekerjaan.text.toString()
            val pelatihan = txtpelatihan.text.toString()

            if (pekerjaan.isEmpty()){
                txtpekerjaan.error = "Pekerjaan Kosong"
                txtpekerjaan.requestFocus()
                return@setOnClickListener
            }
            if (pelatihan.isEmpty()){
                txtpelatihan.error = "Pelatihan Kosong"
                txtpelatihan.requestFocus()
                return@setOnClickListener
            }

            ApiService.instance.TambahDatakaryawan(id, pekerjaan, pelatihan)
                    .enqueue(object : Callback<TambahDataKaryawanResponse> {
                        override fun onResponse(call: Call<TambahDataKaryawanResponse>, response: Response<TambahDataKaryawanResponse>) {
                            if (response.isSuccessful){
                                val intent = Intent(getActivity(), KaryawanActivity::class.java)
                                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                                startActivity(intent)
                                Toast.makeText(getActivity(), response.body()?.message,Toast.LENGTH_SHORT).show()
                            }
                        }

                        override fun onFailure(call: Call<TambahDataKaryawanResponse>, t: Throwable) {
                            Toast.makeText(context, "Tambah Data Karyawan", Toast.LENGTH_SHORT).show()
                        }

                    })
        }

        return view
    }
}