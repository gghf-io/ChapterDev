package io.gghf.chapterdev

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import io.gghf.chapterdev.ui.theme.ChapterDevTheme
import io.gghf.core.Tag
import io.gghf.featuretodo.TodoAddScreen
import io.gghf.featuretodo.TodoListScreen
import io.gghf.featuretodo.di.todoModule
import io.gghf.uilibrary.scaffold.MainScaffold
import io.gghf.uilibrary.topbar.MainTopBar
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        startKoin {
            androidLogger()
            androidContext(this@MainActivity)
            modules(todoModule)
        }

        setContent {
            ChapterDevTheme {
                val navController = rememberNavController()
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background,
                ) {
                    MainScaffold(
                        topBar = {
                            MainTopBar(
                                title = "TodoList",
                                onBackPressed = { Log.d("MainTopBar", "Back Pressed") })
                        }
                    ) { padding ->
                        NavHost(navController = navController, startDestination = Tag.Screen.List) {
                            composable(Tag.Screen.List) { TodoListScreen(padding) }
                            composable(Tag.Screen.Add) { TodoAddScreen() }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ChapterDevTheme {
        Text("Android")
    }
}