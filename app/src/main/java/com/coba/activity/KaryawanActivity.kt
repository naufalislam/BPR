package com.coba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.coba.R
import com.coba.fragment.AccountFragmentKaryawan
import com.coba.fragment.HomeFragmentKaryawan
import com.google.android.material.bottomnavigation.BottomNavigationView

class KaryawanActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karyawan)
//        set Home Fragment menjadi default fragment
        loadFragment(HomeFragmentKaryawan())
//        inisialisasi Bottom Navigation
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav)
//        listener pada saat item bottomnavigation dipilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
       var fragment : Fragment? = null
        when(item.itemId){
            R.id.home_menu -> fragment = HomeFragmentKaryawan()
            R.id.account_menu-> fragment = AccountFragmentKaryawan()
        }
        return loadFragment(fragment)
    }

    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container, fragment)
                    .commit()
            return true
        }
        return false
    }

    override fun onPointerCaptureChanged(hasCapture: Boolean) {}
}