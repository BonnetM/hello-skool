package com.octo.skool.front.helloskool.main

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

data class JsonHero(
    val response: String,
    val id: String,
    val name: String,
    val powerstats: JsonHeroPowerStats,
    val image: JsonHeroImage
)

data class JsonHeroPowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

data class JsonHeroImage(
    val url: String
)

interface HeroesService {
    @GET("{id}")
    fun getHero(@Path("id") id: String): Call<JsonHero>
}