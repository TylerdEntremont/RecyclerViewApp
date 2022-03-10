package com.android.recyclerviewapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.android.recyclerviewapp.databinding.ActivityMainBinding
import com.android.recyclerviewapp.views.FirstFragment


class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)
        //findNavController(R.id.main_frag_container)

        if (savedInstanceState == null)
        { fragmentNavigation(supportFragmentManager, FirstFragment.newInstance())}

    }

}