package com.dsa.arrayproblems

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.dsa.arrayproblems.problems.StringPermutations

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        StringPermutations.printPermutations("aabc")
    }
}
