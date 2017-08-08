package com.example.tim.githubrepossearching.model.data

import com.google.gson.annotations.SerializedName


/**
 * Created by TIM on 08.08.2017.
 */
data class ListOfRepos(

        @SerializedName("total_count") var totalCount: Int,
        @SerializedName("incomplete_results") var incompleteResults: Boolean,
        @SerializedName("items") var items: List<Repository>
)
