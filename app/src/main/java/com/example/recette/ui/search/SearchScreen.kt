package com.example.recette

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberImagePainter
import com.example.recette.domain.item.RecetteItem
import com.example.recette.ui.search.SearchViewModel

@Composable
fun SearchScreen(
    navController: NavController
) {
    val searchViewModel = viewModel(modelClass = SearchViewModel::class.java)
    val recettes by searchViewModel.recettes.collectAsState()

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column()
        {
            Title("Search")
        }
    }

    LazyColumn {
        items(recettes) { recette: RecetteItem ->
            RecetteCard(recette = recette)
        }
    }
    

}

@Composable
fun RecetteCard(recette: RecetteItem)
{
    val image = rememberImagePainter(data = recette.image)
    
    Card(
        elevation = 5.dp,
        shape = RoundedCornerShape(5.dp),
        modifier = Modifier
            .padding(top = 5.dp, bottom = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize()
    ){
        Column {
            Image(
                painter = image,
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(250.dp)
            )
            Column(modifier = Modifier.padding(10.dp)) {
                Text(text = recette.title, fontWeight = FontWeight.Bold)
            }
        }
    }
}

