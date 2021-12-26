package com.coba.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.coba.R
import com.coba.fragment.AccountFragmentAdmin
import com.coba.fragment.HomeFragmentAdmin
import com.google.android.material.bottomnavigation.BottomNavigationView

class AdminActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin)

        //       Set Home Fragment menjadi default
        loadFragment(HomeFragmentAdmin())
//        inisialisasi BottomNavigationView
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNav_admin)
//        listener pada saat item/menu bottomnavigation terpilih
        bottomNavigationView.setOnNavigationItemSelectedListener(this)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        var fragment: Fragment? = null
        when(item.itemId){
            R.id.home_menu -> fragment = HomeFragmentAdmin()
            R.id.account_menu -> fragment = AccountFragmentAdmin()
        }
        return loadFragment(fragment)
    }

    //    untuk load fragment yang sesuai
    private fun loadFragment(fragment: Fragment?): Boolean {
        if (fragment != null){
            supportFragmentManager.beginTransaction()
                    .replace(R.id.fl_container_admin, fragment)
                    .commit()
            return true
        }
        return false
    }
}