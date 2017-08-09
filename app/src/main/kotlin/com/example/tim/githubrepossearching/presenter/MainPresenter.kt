package com.example.tim.githubrepossearching.presenter

import com.example.tim.githubrepossearching.model.IModel
import com.example.tim.githubrepossearching.model.Model
import com.example.tim.githubrepossearching.model.data.CustomRepo
import com.example.tim.githubrepossearching.tools.isStoped
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

    override fun getData(query: String) {

        if (isStoped) {
            isStoped = !isStoped
            activity.showProgress()
            subscription = model.getCustomReposList(query)
                    .map { listOfRepos -> listOfRepos.items }
                    .flatMap { list -> Observable.from(list) }
                    .map { list -> CustomRepo(list.id, list.name, list.htmlUrl) }
                    .toList()
                    .subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(
                            { listCustomRepo ->
                                activity.setData(listCustomRepo as ArrayList<CustomRepo>)
                                isStoped = true},
                            { e -> activity.showException(e) })
        } else {
            isStoped = !isStoped
            if (subscription != null && !subscription!!.isUnsubscribed)
                subscription!!.unsubscribe()
            activity.hideProgress()
        }
    }

    override fun onUnsubscribe() {
        if (subscription != null && !subscription!!.isUnsubscribed)
            subscription!!.unsubscribe()
    }
}