package com.example.moviedb.movie.ui.models

import android.os.Parcelable
import com.example.moviedb.movie.domin.entities.MovieDomainModel
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class MovieUIModel (
    val id: Long,
    @SerializedName("poster_path")
    val posterPath: String,
    @SerializedName("release_date")
    val releaseDate: String,
    val title: String,
    @SerializedName("vote_average")
    val voteAverage: Double,
):Parcelable
fun MovieDomainModel.toUIModel(): MovieUIModel {
    return MovieUIModel(
        title = this.title,
        posterPath = this.posterPath,
        releaseDate = this.releaseDate,
        voteAverage = this.voteAverage,
        id = this.id,
    )
}