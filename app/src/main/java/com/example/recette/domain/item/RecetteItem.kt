package com.example.recette.domain.item

import com.example.recette.data.remote.RecetteApi
import com.example.recette.data.remote.model.SearchModel

data class RecetteItem(
    val id: Int,
    val image: String,
    val imageType: String,
    val title: String
)

fun SearchModel.toRecetteItem() = RecetteItem(id,image,imageType,title)
