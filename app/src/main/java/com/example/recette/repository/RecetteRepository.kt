package com.example.recette.repository

import com.example.recette.data.remote.RecetteService
import com.example.recette.domain.item.RecetteItem
import com.example.recette.domain.item.toRecetteItem
import javax.inject.Inject

class RecetteRepository @Inject constructor(private val recetteService: RecetteService){

    suspend fun getRecettes(): List<RecetteItem>
    {

        return recetteService.getRecettes().map {
            it.toRecetteItem()
        }

    }

}