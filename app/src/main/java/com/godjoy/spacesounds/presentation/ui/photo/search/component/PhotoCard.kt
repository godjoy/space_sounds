package com.godjoy.spacesounds.presentation.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import com.godjoy.spacesounds.domain.model.NasaPhoto
import com.godjoy.spacesounds.domain.model.nasaPhoto
import com.godjoy.spacesounds.utils.NetworkImage
import java.util.*

@Composable
fun PhotoCard(
    modifier: Modifier = Modifier,
    photo: NasaPhoto,
    selectPhoto: (String) -> Unit
) {
    Surface(
        modifier = modifier
    ) {
        ConstraintLayout(
            modifier = Modifier.clickable(
                onClick = { selectPhoto(photo.nasaId) }
            )
        ) {
            val (image, avatar, title, date) = createRefs()
            NetworkImage(
                url = photo.imgSrc,
                contentDescription = null,
                modifier = Modifier
                    .aspectRatio(4f / 3f)
                    .constrainAs(image) {
                        centerHorizontallyTo(parent)
                        top.linkTo(parent.top)
                    }
            )
            OutlinedAvatar(
                url = photo.imgSrc,
                modifier = Modifier
                    .size(38.dp)
                    .constrainAs(avatar) {
                        centerHorizontallyTo(parent)
                        centerAround(image.bottom)
                    }
            )
            Text(
                text = photo.date.uppercase(Locale.getDefault()),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.overline,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(date) {
                        centerHorizontallyTo(parent)
                        top.linkTo(avatar.bottom)
                    }
            )
            Text(
                text = photo.title,
                style = MaterialTheme.typography.subtitle2,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(20.dp)
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(date.bottom)
                    }
            )
        }
    }
}

@Preview
@Composable
private fun PostCardPreview() {
    PhotoCard(photo = nasaPhoto, selectPhoto = {})
}