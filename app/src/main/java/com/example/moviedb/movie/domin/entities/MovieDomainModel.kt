package com.example.moviedb.movie.domin.entities

import com.example.moviedb.movie.data.movieEntity.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieDomainModel (
    val id: Long,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
)
fun MovieModel.toDomainModel(): MovieDomainModel {
    return MovieDomainModel(
        title = this.title,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        voteAverage = this.voteAverage,
        id = this.id,
    )
}