package com.example.recette.data.remote

import com.example.recette.data.remote.model.SearchModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RecetteService @Inject constructor(private val recetteApi: RecetteApi){

    suspend fun getRecettes(): List<SearchModel>
    {
        return withContext(Dispatchers.IO) {
            val recettes = recetteApi.getSearch()
            recettes.body() ?: emptyList()
        }
    }
}