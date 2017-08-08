package com.example.tim.githubrepossearching.model.api

import com.example.tim.githubrepossearching.model.data.ListOfRepos
import com.example.tim.githubrepossearching.tools.SEARCH_REPOS
import com.example.tim.githubrepossearching.tools.SEARCH_TERM
import retrofit2.http.GET
import retrofit2.http.Query
import rx.Observable

interface ApiInterface {

    @GET(SEARCH_REPOS)
    fun getRepos(@Query(SEARCH_TERM) query: String,
                 @Query("page") page: Int,
                 @Query("per_page") perPage: Int): Observable<ListOfRepos>
}
