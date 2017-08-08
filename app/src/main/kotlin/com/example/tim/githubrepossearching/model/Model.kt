package com.example.tim.githubrepossearching.model

import com.example.tim.githubrepossearching.model.api.ApiModule
import com.example.tim.githubrepossearching.model.data.ListOfRepos
import rx.Observable


/**
 * Created by TIM on 08.08.2017.
 */
class Model : IModel {

    override fun getCustomReposList(searchQuery: String): Observable<ListOfRepos> {
        return ApiModule().getApiInterface().getRepos("$searchQuery in:name", 1, 100)
    }
}