package com.example.f1service

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.navigation.fragment.NavHostFragment
import com.example.f1service.ui.homepage.Homepage
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mFragmentManager = this.supportFragmentManager.beginTransaction()
        mFragmentManager.replace(R.id.main_nav_host_fragment,Homepage())
        mFragmentManager.commit()
    }
}






















