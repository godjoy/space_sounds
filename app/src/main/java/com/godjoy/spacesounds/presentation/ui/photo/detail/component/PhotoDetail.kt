package com.godjoy.spacesounds.presentation.ui.photo.detail.component


import androidx.compose.foundation.layout.*
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
import com.godjoy.spacesounds.presentation.ui.component.OutlinedAvatar
import com.godjoy.spacesounds.utils.NetworkImage
import java.util.*

private enum class SheetState { Open }

@Composable
fun PhotoDetail(
    modifier: Modifier = Modifier,
    photo: NasaPhoto
) {
    Surface(
        modifier = modifier
    ) {
        ConstraintLayout(
            modifier = Modifier.fillMaxSize()
        ) {
            val (image, avatar, title, date, description) = createRefs()
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
                    .size(40.dp)
                    .constrainAs(avatar) {
                        centerHorizontallyTo(parent)
                        centerAround(image.bottom)
                    }
            )
            Text(
                text = photo.date.uppercase(Locale.getDefault()),
                color = MaterialTheme.colors.primary,
                style = MaterialTheme.typography.body2,
                modifier = Modifier
                    .padding(10.dp)
                    .constrainAs(date) {
                        centerHorizontallyTo(parent)
                        top.linkTo(avatar.bottom)
                    }
            )
            Text(
                text = photo.title,
                style = MaterialTheme.typography.h4,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(25.dp)
                    .constrainAs(title) {
                        centerHorizontallyTo(parent)
                        top.linkTo(date.bottom)
                    }
            )
            Text(
                text = photo.description,
                style = MaterialTheme.typography.h6,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(30.dp)
                    .constrainAs(description) {
                        centerHorizontallyTo(parent)
                        top.linkTo(title.bottom)
                    }
            )
        }
    }
}

@Preview
@Composable
fun PhotoDetailPreview() {
    PhotoDetail(photo = nasaPhoto)
}