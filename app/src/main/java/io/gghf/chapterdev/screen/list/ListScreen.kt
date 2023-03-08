package io.gghf.chapterdev.screen.list

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import io.gghf.core.Tag
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ListScreen(padding: PaddingValues, presenter: ListViewModel = koinViewModel()) {

    val todosState = presenter.todos.observeAsState()

    todosState.value?.let { list ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(list) {
                Card(onClick = { Log.d(Tag.Screen.List, it.title) }) {
                    Text(text = it.title)
                    Text(text = it.text)
                }
            }
        }
    }
}