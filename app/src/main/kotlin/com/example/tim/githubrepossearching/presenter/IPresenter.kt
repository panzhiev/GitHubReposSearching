package com.example.tim.githubrepossearching.presenter

import id.kotlin.sample.room.data.Repo

/**
 * Created by TIM on 08.08.2017.
 */
interface IPresenter {
    fun getData()
    fun onUnsubscribe()
    fun addRepo(repo: Repo)
    fun getRepos()
}