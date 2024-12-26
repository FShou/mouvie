package com.fshou.mouvie.ui.components

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.fshou.mouvie.ui.theme.MouvieTheme

@Composable
fun PageTitle(
    modifier: Modifier = Modifier,
    text: String = ""
) {
    Row(modifier.fillMaxWidth().padding(horizontal = 24.dp)) {
        Text(
            modifier = Modifier.weight(1f),
            text = text,
            style = MaterialTheme.typography.displaySmall,
            color = Color.White

        )
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Preview
@Composable
private fun PageTitlePrev() {
    MouvieTheme {
        PageTitle(text = "Home")
    }
}