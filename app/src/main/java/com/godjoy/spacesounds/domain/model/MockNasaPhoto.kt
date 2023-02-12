package com.godjoy.spacesounds.domain.model

val nasaPhoto = NasaPhoto(
        nasaId = "PIA16884",
        imgSrc = "images-assets.nasa.gov/image/PIA16884/PIA16884~orig.jpg",
        title = "Taken Under the Wing of the Small Magellanic Cloud",
        description = "The tip of the wing of the Small Magellanic Cloud galaxy " +
                "is dazzling in this new view from NASA Great Observatories. " +
                "The SMC, is a small galaxy about 200,000 light-years way that orbits our own Milky Way spiral galaxy.",
        date = "2013-04-03"
    )

val nasaPhotos = listOf<NasaPhoto>(
        nasaPhoto,
        nasaPhoto.copy(
                nasaId = "PIA14401",
                imgSrc = "images-assets.nasa.gov/image/PIA18471/PIA18471~orig.jpg"
        ),
        nasaPhoto.copy(
                nasaId = "PIA14402",
                imgSrc = "images-assets.nasa.gov/image/PIA14402/PIA14402~orig.jpg"
        ),
        nasaPhoto.copy(
                nasaId = "PIA14403",
                imgSrc = "images-assets.nasa.gov/image/PIA14402/PIA14402~orig.jpg"
        ),
        nasaPhoto.copy(
                nasaId = "PIA14404",
                imgSrc = "images-assets.nasa.gov/image/PIA14402/PIA14402~orig.jpg"
        ),
        nasaPhoto.copy(
                nasaId = "PIA14405",
                imgSrc = "images-assets.nasa.gov/image/PIA14402/PIA14402~orig.jpg"
        ),
        nasaPhoto.copy(
                nasaId = "PIA14406",
                imgSrc = "images-assets.nasa.gov/image/PIA18471/PIA18471~orig.jpg"
        ),
)