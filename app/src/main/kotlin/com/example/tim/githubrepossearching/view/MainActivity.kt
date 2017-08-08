package com.example.tim.githubrepossearching.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.example.tim.githubrepossearching.R
import com.tim.kotlinjakewharton.view.activities.IActivity

class MainActivity : AppCompatActivity(), IActivity {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun setData(list: ArrayList<String>) {

    }

    override fun showException(e: Throwable) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
    }

//    override fun onStop() {
//        mainPresenter.onUnsubscribe()
//        super.onStop()
//    }
}
