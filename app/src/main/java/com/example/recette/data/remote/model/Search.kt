package com.example.recette.data.remote.model

data class Search(
    val number: Int,
    val offset: Int,
    val results: List<SearchModel>,
    val totalResults: Int
)