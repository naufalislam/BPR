package com.coba.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.coba.R
import com.coba.model.PelamarModel

class AdapterPelamar (val pelamar : ArrayList<PelamarModel.Data>)
    :RecyclerView.Adapter<AdapterPelamar.ViewHolder>(){




    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val Pelamar = view.findViewById<LinearLayout>(R.id.pelamar)
        val TextNama =  view.findViewById<TextView>(R.id.nama)
        val TempatTanggalLahir = view.findViewById<TextView>(R.id.ttl)
        val Posisi = view.findViewById<TextView>(R.id.posisi)



    }



    public fun setData(data: List<PelamarModel.Data>){
        pelamar.clear()
        pelamar.addAll(data)
        notifyDataSetChanged()
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterPelamar.ViewHolder {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: AdapterPelamar.ViewHolder, position: Int) {

        holder.Pelamar.setOnClickListener {

       }
    }

    override fun getItemCount()= pelamar.size


}