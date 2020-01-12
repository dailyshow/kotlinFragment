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
            // add로 하게되면 first, second fragment 가 겹치게 된다. framelayout 위에다 보여주기 때문이다.
            // tran.add(R.id.container, first)
            // replace 로 해줘서 화면이 교체되도록 한다.
            tran.replace(R.id.container, first)
            // fragment backstack에 추가해줘서 back button 을 눌렀을 때 이전 화면으로 이동하는 것처럼 보이게 할 수 있다.
            tran.addToBackStack("first") // 이름 대신 null 을 넣어줘도 되긴 하지만 특정 fragment로 이동시킬 수는 없게된다.
            tran.commit()
        }

        mainBtn2.setOnClickListener { view ->
            val tran = supportFragmentManager.beginTransaction()
            // tran.add(R.id.container, second)
            tran.replace(R.id.container, second)
            tran.addToBackStack("second")
            tran.commit()
        }
    }
}
