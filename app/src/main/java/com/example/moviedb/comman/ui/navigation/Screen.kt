package com.example.moviedb.comman.ui.navigation

sealed class Screen(val route:String) {
    object HomeScreen : Screen("home_screen")
    object MovieDetailsScreen : Screen("movie_details_screen")

    fun withArgs(vararg  args :String):String
    {
        return buildString {
            append(route)
            args.forEach {arg->
                append("/{$args}")
            }
        }
    }
}