package com.octo.skool.front.helloskool.main

interface HeroesView {
    fun displayHeroes(list: List<Hero>)
}

class HeroesPresenter(
    private val heroesRepository: HeroesRepository,
    private val heroesView: HeroesView
) {
    fun load() {
        (1..10)
            .map(Int::toString)
            .mapNotNull {
                heroesRepository.fetchHero(it)
            }
            .let(heroesView::displayHeroes)
    }

}
