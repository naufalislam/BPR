package com.coba.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.coba.R
import com.coba.adapter.AdapterPelamar
import com.coba.model.PelamarModel
import com.coba.network.ApiService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentAdmin : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var pelamarAdapter : AdapterPelamar

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_home_admin,container, false)
        val listPelamar = view.findViewById<RecyclerView>(R.id.list_data_pelamar)
        pelamarAdapter = AdapterPelamar(arrayListOf())

        listPelamar.adapter=pelamarAdapter

        return view
    }

    override fun onStart() {
        super.onStart()
        getPelamar()
    }

    private fun getPelamar() {
        ApiService.instance.Karyawan()
                .enqueue(object : Callback<PelamarModel> {
                    override fun onResponse(call: Call<PelamarModel>, response: Response<PelamarModel>) {
                        if(response.isSuccessful){
                            val ListData = response.body()!!.data
                            pelamarAdapter.setData(ListData)
                        }
                    }

                    override fun onFailure(call: Call<PelamarModel>, t: Throwable) {
                        Toast.makeText(activity, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }

                })
    }
}