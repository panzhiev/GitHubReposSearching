package com.example.tim.githubrepossearching.presenter

import com.example.tim.githubrepossearching.model.IModel
import com.example.tim.githubrepossearching.model.Model
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
                .flatMap { list -> Observable.from(list) }
                .map { obj -> obj.name }
                .toList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe()

//                { s -> activity.setData(s as ArrayList<String>) },
//        { e -> activity.showException(e) }
    }

    override fun onUnsubscribe() {
        if (subscription != null && !subscription!!.isUnsubscribed)
            subscription!!.unsubscribe()
    }
}