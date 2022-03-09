package com.android.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.android.recyclerviewapp.views.FirstFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentNavigation(supportFragmentManager, FirstFragment.newInstance())
    }

}