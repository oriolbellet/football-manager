package org.oriolbellet.football.domain.season.gameweek

import org.oriolbellet.football.domain.Default
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

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GameWeek

        if (gameWeekId != other.gameWeekId) return false
        if (matches != other.matches) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gameWeekId?.hashCode() ?: 0
        result = 31 * result + matches.hashCode()
        return result
    }


}