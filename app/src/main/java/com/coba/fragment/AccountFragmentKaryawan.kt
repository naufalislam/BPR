package com.coba.fragment

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.Fragment
import com.coba.R
import com.coba.activity.LoginActivity
import com.coba.activity.MainActivity
import com.coba.storage.SharedPrefManager

class AccountFragmentKaryawan : Fragment() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_account_karyawan, container, false)
        val id = SharedPrefManager.getInstance(requireContext()).data.id
        val nama = SharedPrefManager.getInstance(requireContext()).data.nama
        val email = SharedPrefManager.getInstance(requireContext()).data.email

        val btnLogOut : CardView = view.findViewById(R.id.cvLogout)
        val btnEdit : CardView = view.findViewById(R.id.cvEdit)

        val namaUser : TextView = view.findViewById(R.id.nama_user)
        val ttlUser : TextView = view.findViewById(R.id.tempatlahir_user)
        val posisiUser : TextView = view.findViewById(R.id.posisi_user)

        namaUser.text = nama
        ttlUser.text = email



        btnEdit.setOnClickListener { EditData() }
        btnLogOut.setOnClickListener { LogOut() }

        return view
    }

    private fun EditData(){
        val intent = Intent(getActivity(), MainActivity::class.java)
        getActivity()?.startActivity(intent)
        getActivity()?.finish()
    }

    private fun LogOut(){
        SharedPrefManager.getInstance(requireActivity()).clear()
        val intent = Intent(getActivity(), LoginActivity::class.java)
        getActivity()?.startActivity(intent)
        getActivity()?.finish()
    }
}