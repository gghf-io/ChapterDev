package io.gghf.uilibrary.scaffold

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable

@Composable
fun MainScaffold(topBar: @Composable () ->  Unit, content: @Composable (PaddingValues) -> Unit) {
    Scaffold(
        topBar = topBar,
        content = content
    )
}