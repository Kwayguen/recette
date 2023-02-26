package com.example.recette.ui.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.recette.domain.GetRecettesUseCase
import com.example.recette.domain.item.RecetteItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private  val getRecettesUseCase: GetRecettesUseCase) : ViewModel() {

    private val _recettes = MutableStateFlow(emptyList<RecetteItem>())
    val recettes: StateFlow<List<RecetteItem>> get() = _recettes

    init {
        getRecettes()
    }

    private fun getRecettes()
    {

        viewModelScope.launch {

            try {

                val recettes = getRecettesUseCase()
                _recettes.value = recettes

            } catch (_: Exception) {

            }

        }

    }

}