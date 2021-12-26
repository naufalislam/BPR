package com.coba.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.coba.R
import com.coba.model.DataKaryawanModel
import com.coba.model.UserModel

class UserAdapter (val user : ArrayList<DataKaryawanModel.Data>)
    :RecyclerView.Adapter<UserAdapter.ViewHolder>(){


        class ViewHolder(view: View): RecyclerView.ViewHolder(view){
            val Pekerjaan =  view.findViewById<TextView>(R.id.pekerjaan)
            val Pelatihan =  view.findViewById<TextView>(R.id.pelatihan)
        }

    fun setData(data: List<DataKaryawanModel.Data>){
        user.clear()
        user.addAll(data)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder (
        LayoutInflater.from(parent.context)
                .inflate(R.layout.adapter_data_karyawan,parent,false)
            )


    override fun onBindViewHolder(holder: UserAdapter.ViewHolder, position: Int) {
        val data = user[position]
        val id = data.id
        val idKaryawan = data.karyawan_id
        val pekerjaan = data.pekerjaan
        val pelatihan = data.pelatihan

        holder.Pekerjaan.text = data.pekerjaan
        holder.Pelatihan.text = data.pelatihan
    }

    override fun getItemCount()=user.size
}