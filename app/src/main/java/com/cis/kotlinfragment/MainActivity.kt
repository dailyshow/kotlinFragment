package com.cis.kotlinfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    var first = FirstFragment()
    var second = SecondFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mainBtn1.setOnClickListener { view ->
            val tran = supportFragmentManager.beginTransaction()
//            tran.add(R.id.container, first)
            tran.replace(R.id.container, first)
            tran.addToBackStack("first")
            tran.commit()
        }

        mainBtn2.setOnClickListener { view ->
            var tran = supportFragmentManager.beginTransaction()
//            tran.add(R.id.container, second)
            tran.replace(R.id.container, second)
            tran.addToBackStack("second")
            tran.commit()
        }
    }
}
