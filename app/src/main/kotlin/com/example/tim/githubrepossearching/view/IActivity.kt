package com.tim.kotlinjakewharton.view.activities

import com.example.tim.githubrepossearching.model.data.CustomRepo

/**
 * Created by TIM on 22.07.2017.
 */
interface IActivity {
    fun setData(list: ArrayList<CustomRepo>)
    fun showException(e: Throwable)
    fun showProgress()
    fun hideProgress()
}