package com.example.tim.githubrepossearching.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.example.tim.githubrepossearching.R
import com.example.tim.githubrepossearching.model.data.CustomRepo
import com.example.tim.githubrepossearching.presenter.IPresenter
import com.example.tim.githubrepossearching.presenter.MainPresenter
import com.example.tim.githubrepossearching.view.adapters.RecyclerViewAdapter
import com.tim.kotlinjakewharton.view.activities.IActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IActivity {

    private val mainPresenter: IPresenter = MainPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_search.setOnClickListener { mainPresenter.getData() }
    }

    override fun setData(list: ArrayList<CustomRepo>) {
        rv_repos.hasFixedSize()
        rv_repos.adapter = RecyclerViewAdapter(this, list)
    }

    override fun showException(e: Throwable) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        Log.d("exception", e.toString())
    }

    override fun onStop() {
        mainPresenter.onUnsubscribe()
        super.onStop()
    }
}
