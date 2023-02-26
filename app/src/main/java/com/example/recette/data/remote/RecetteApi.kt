package com.example.recette.data.remote

import com.example.recette.Screen
import com.example.recette.data.remote.model.SearchModel
import com.example.recette.util.Constants.Companion.SEARCH_ENDPOINT
import retrofit2.Response
import retrofit2.http.GET

interface RecetteApi {

    @GET(SEARCH_ENDPOINT)
    suspend fun getSearch(): Response<List<SearchModel>>

}