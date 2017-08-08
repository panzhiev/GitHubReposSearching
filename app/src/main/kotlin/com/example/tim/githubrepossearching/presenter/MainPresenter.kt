package com.example.tim.githubrepossearching.presenter

import com.example.tim.githubrepossearching.model.IModel
import com.example.tim.githubrepossearching.model.Model
import com.example.tim.githubrepossearching.model.data.CustomRepo
import com.example.tim.githubrepossearching.view.MainActivity
import rx.Observable
import rx.Subscription
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/**
 * Created by TIM on 08.08.2017.
 */
class MainPresenter(var activity: MainActivity) : IPresenter {

    private var subscription: Subscription? = null
    private var model: IModel = Model()

    override fun getData() {
        subscription = model.getCustomReposList("jquery")
                .map { listOfRepos -> listOfRepos.items }
                .flatMap { list -> Observable.from(list) }
                .map { list -> CustomRepo(list.id, list.name, list.htmlUrl)}
                .toList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ listCustomRepo -> activity.setData(listCustomRepo as ArrayList<CustomRepo>) },
                        { e -> activity.showException(e) })
    }

    override fun onUnsubscribe() {
        if (subscription != null && !subscription!!.isUnsubscribed)
            subscription!!.unsubscribe()
    }
}