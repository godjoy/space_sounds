package com.godjoy.spacesounds.presentation.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.godjoy.spacesounds.utils.NetworkImage

@Composable
fun OutlinedAvatar(
    modifier: Modifier = Modifier,
    url: String?,
    outlineSize: Dp = 3.dp,
    outlineColor: Color = MaterialTheme.colors.surface
) {
    Box(modifier = modifier.background(
        color = outlineColor,
        shape = CircleShape
    )) {
        NetworkImage(
            url = url,
            contentDescription = null,
            modifier = Modifier
                .padding(outlineSize)
                .fillMaxSize()
                .clip(CircleShape)
        )
    }
}

@Preview(
    widthDp = 40,
    heightDp = 40
)
@Composable
private fun OutlinedAvatarPreview() {
    OutlinedAvatar(url = "")
}