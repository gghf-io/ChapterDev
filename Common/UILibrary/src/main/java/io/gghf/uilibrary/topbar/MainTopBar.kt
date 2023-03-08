package io.gghf.uilibrary.topbar

import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.style.TextAlign

@Composable
fun MainTopBar(title: String, onBackPressed: () -> Unit) {
    TopAppBar(
        title = {
            Text(
                text = title,
                textAlign = TextAlign.Center
            )
        }
    )
}