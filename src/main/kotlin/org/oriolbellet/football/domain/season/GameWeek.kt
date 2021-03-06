package org.oriolbellet.football.domain.season

import org.oriolbellet.football.adapter.out.model.Default
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchAlgorithm

class GameWeek(matches: List<Match>) {

    var gameWeekId: Long? = null
    val matches = matches.toMutableList()

    @Default
    constructor(gameWeekId: Long, matches: List<Match>) : this(matches) {
        this.gameWeekId = gameWeekId
    }

    fun play(matchAlgorithm: MatchAlgorithm) {
        this.matches.forEach {
            it.play(matchAlgorithm)
        }
    }

}