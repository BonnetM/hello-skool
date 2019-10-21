package com.octo.skool.front.helloskool.main

data class Hero(
    val id: String,
    val name: String,
    val powerStats: HeroPowerStats,
    val imageUrl: String
)

data class HeroPowerStats(
    val intelligence: String,
    val strength: String,
    val speed: String,
    val durability: String,
    val power: String,
    val combat: String
)

class HeroesRepository(
    private val heroesService: HeroesService
) {
    fun fetchHero(id: String): Hero? {
        try {
            val response = heroesService.getHero(id).execute()
            return if (response.isSuccessful) {
                response.body()?.let {
                    Hero(
                        id = it.id,
                        name = it.name,
                        powerStats = it.powerstats.let { stats ->
                            HeroPowerStats(
                                stats.intelligence,
                                stats.strength,
                                stats.speed,
                                stats.durability,
                                stats.power,
                                stats.combat
                            )
                        },
                        imageUrl = it.image.url
                    )
                }
            } else {
                null
            }

        } catch (e: Throwable) {
            return null
        }
    }

}
