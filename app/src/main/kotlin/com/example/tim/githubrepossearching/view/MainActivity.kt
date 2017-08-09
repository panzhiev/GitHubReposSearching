package com.example.tim.githubrepossearching.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Toast
import com.example.tim.githubrepossearching.R
import com.example.tim.githubrepossearching.presenter.IPresenter
import com.example.tim.githubrepossearching.presenter.MainPresenter
import com.example.tim.githubrepossearching.view.adapters.RecyclerViewAdapter
import com.tim.kotlinjakewharton.view.activities.IActivity
import com.example.tim.githubrepossearching.databases.room.Repo
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), IActivity {

    private val mainPresenter: IPresenter = MainPresenter(this)
    private var listRepos: ArrayList<Repo> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (lastCustomNonConfigurationInstance != null) {
            listRepos = lastCustomNonConfigurationInstance as ArrayList<Repo>
            setData(listRepos)
        }

        btn_search.setOnClickListener {
            if (et_search.text.toString() != "")
                mainPresenter.getData()
            else Toast.makeText(this, "Enter the search text, please", Toast.LENGTH_SHORT).show()
        }
    }

    override fun setData(list: ArrayList<Repo>) {
        listRepos = list
        rv_repos.hasFixedSize()
        rv_repos.adapter = RecyclerViewAdapter(this, listRepos)
        hideProgress()
    }

    override fun showException(e: Throwable) {
        Toast.makeText(this, e.toString(), Toast.LENGTH_LONG).show()
        Log.d("showException", e.toString())
    }

    override fun showProgress() {
        progress_bar.visibility = View.VISIBLE
    }

    override fun hideProgress() {
        progress_bar.visibility = View.GONE
    }

    override fun onRetainCustomNonConfigurationInstance(): Any {
        return listRepos
    }

    override fun onStop() {
        mainPresenter.onUnsubscribe()
        super.onStop()
    }
}
