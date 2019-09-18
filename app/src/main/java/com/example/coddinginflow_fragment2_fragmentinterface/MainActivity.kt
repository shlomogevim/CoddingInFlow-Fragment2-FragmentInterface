package com.example.coddinginflow_fragment2_fragmentinterface

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), FirstFragment.FregmatAListener,
    SecondFragment.FregmatBListener {

    lateinit var fragmentA: FirstFragment
    lateinit var fragmentB: SecondFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        fragmentA = FirstFragment()
        fragmentB = SecondFragment()
        supportFragmentManager.beginTransaction()
            .replace(R.id.container_a, fragmentA)
            .replace(R.id.container_b, fragmentB)
            .commit()
    }

    override fun onInputASent(input: CharSequence) {
        fragmentB.updateEditText(input)
    }

    override fun onInputBSent(input: CharSequence) {
        fragmentA.updateEditText(input)
    }

}
