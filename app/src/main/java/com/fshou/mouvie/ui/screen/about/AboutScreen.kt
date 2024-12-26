package com.fshou.mouvie.ui.screen.about

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.fshou.mouvie.R
import com.fshou.mouvie.ui.components.PageTitle
import com.fshou.mouvie.ui.theme.MouvieTheme
import com.fshou.mouvie.ui.utils.borderGradientBrush

@Composable
fun AboutScreen(modifier: Modifier = Modifier) {
    Column(modifier) {
        PageTitle(text = "About")
        Column(
            modifier = Modifier
                .fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painterResource(id = R.drawable.profile_pic),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape)
                    .border(brush = borderGradientBrush, width = 4.dp, shape = CircleShape)
            )
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Achmad Faqih Suyudi",
                style = MaterialTheme.typography.titleLarge,
                fontSize = 20.sp
            )
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = "faqihsuyudi2020@gmail.com",
                style = MaterialTheme.typography.bodyLarge,
                color = Color(0xaaffffff),
                fontSize = 14.sp
            )
        }
    }
}

@Preview
@Composable
private fun AboutScreenPrev() {
    MouvieTheme {
        AboutScreen()
    }
}