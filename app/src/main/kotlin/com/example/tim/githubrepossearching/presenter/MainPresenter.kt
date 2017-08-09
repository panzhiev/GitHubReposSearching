package com.example.tim.githubrepossearching.presenter

import com.example.tim.githubrepossearching.App
import com.example.tim.githubrepossearching.databases.SharedPrefsHelper
import com.example.tim.githubrepossearching.model.IModel
import com.example.tim.githubrepossearching.model.Model
import com.example.tim.githubrepossearching.tools.isStoped
import com.example.tim.githubrepossearching.view.MainActivity
import id.kotlin.sample.room.data.Repo
import kotlinx.android.synthetic.main.activity_main.*
import rx.Observable
import rx.Single
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by TIM on 08.08.2017.
 */
class MainPresenter(var activity: MainActivity) : IPresenter {

    private var subscription: Subscription? = null
    private var model: IModel = Model()
    private lateinit var searchQuery: String

    override fun getData() {

        if (isStoped) {
            isStoped = !isStoped
            activity.showProgress()
            searchQuery = activity.et_search.text.toString()

            if (searchQuery == SharedPrefsHelper().getStringValue(activity, "lastSearching")) {
                getRepos()
            } else {
                subscription = model.getReposList(searchQuery)
                        .map { listOfRepos -> listOfRepos.items }
                        .flatMap { list -> Observable.from(list) }
                        .map { list -> Repo(list.id, list.name, list.htmlUrl) }
                        .toList()
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { listRepo ->
                                    activity.setData(listRepo as ArrayList<Repo>)
                                    isStoped = true
                                    for (item in listRepo)
                                        addRepo(item)
                                },
                                { e -> activity.showException(e) },
                                { SharedPrefsHelper().putStringValue(activity, "lastSearching", searchQuery) })
            }
        } else {
            isStoped = !isStoped
            if (subscription != null && !subscription!!.isUnsubscribed)
                subscription!!.unsubscribe()
            activity.hideProgress()
        }
    }

    override fun addRepo(repo: Repo) {
        Single.fromCallable { App.database?.repoDao()?.insert(repo) }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()
    }

    override fun getRepos() {
        Single.fromCallable { App.database?.repoDao()?.getRepos() }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listRepo ->
                            activity.setData(listRepo as ArrayList<Repo>)
                            isStoped = true },
                        { e -> activity.showException(e) })
    }

    override fun onUnsubscribe() {
        if (subscription != null && !subscription!!.isUnsubscribed)
            subscription!!.unsubscribe()
    }
}