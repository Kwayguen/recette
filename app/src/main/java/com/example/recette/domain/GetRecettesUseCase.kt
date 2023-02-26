package com.example.recette.domain

import com.example.recette.domain.item.RecetteItem
import com.example.recette.repository.RecetteRepository
import javax.inject.Inject

class GetRecettesUseCase @Inject constructor(private val recetteRepository: RecetteRepository) {

    suspend operator fun invoke(): List<RecetteItem> {

        return recetteRepository.getRecettes().shuffled()

    }

}