package com.coba.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import androidx.recyclerview.widget.RecyclerView
import com.coba.R
import com.coba.adapter.UserAdapter
import com.coba.model.DataKaryawanModel
import com.coba.network.ApiService
import com.coba.storage.SharedPrefManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class HomeFragmentKaryawan : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    private lateinit var userAdapter: UserAdapter
    private var idUser : Int = 0
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home_karyawan,container, false)
        val tambah : ImageView = view.findViewById(R.id.bt_tambah)
        var listDataKaryawan = view.findViewById<RecyclerView>(R.id.list_data_karyawan)
        idUser = SharedPrefManager.getInstance(requireContext()).data.id
        userAdapter = UserAdapter(arrayListOf())


        listDataKaryawan.adapter = userAdapter

        tambah.setOnClickListener {
            tambahDataUser()
        }


        return view
    }

    private fun tambahDataUser() {
        val fragment: Fragment = TambahDataKaryawanFragment()
        val fragmentManager : FragmentManager = requireActivity().supportFragmentManager
        val fragmentTransaction : FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, fragment)
        fragmentTransaction.commit()
    }

    override fun onStart() {
        super.onStart()
        getDataKaryawan(idUser)
    }

    private fun getDataKaryawan(id: Int) {
        ApiService.instance.DataKaryawan(id)
                .enqueue(object : Callback<DataKaryawanModel> {
                    override fun onResponse(call: Call<DataKaryawanModel>, response: Response<DataKaryawanModel>) {
                        if (response.isSuccessful) {
                            val ListData = response.body()!!.data
                            userAdapter.setData(ListData)
                        }
                        Toast.makeText(context, "Terjadi Kesalahan", Toast.LENGTH_SHORT).show()
                    }

                    override fun onFailure(call: Call<DataKaryawanModel>, t: Throwable) {
                        Log.e("Data Karyawan", t.toString())
                    }

                })
    }
}