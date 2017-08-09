package com.example.tim.githubrepossearching.presenter

import com.example.tim.githubrepossearching.databases.room.Repo

/**
 * Created by TIM on 08.08.2017.
 */
interface IPresenter {
    fun getData()
    fun onUnsubscribe()
    fun addRepo(repo: Repo)
    fun getRepos()
    fun deleteRepos()
}