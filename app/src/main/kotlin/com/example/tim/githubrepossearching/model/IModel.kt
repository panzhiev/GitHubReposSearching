package com.example.tim.githubrepossearching.model

import com.example.tim.githubrepossearching.model.data.CustomRepo
import rx.Observable

/**
 * Created by TIM on 08.08.2017.
 */
interface IModel {
    fun getCustomReposList(searchQuery: String): Observable<List<CustomRepo>>
}