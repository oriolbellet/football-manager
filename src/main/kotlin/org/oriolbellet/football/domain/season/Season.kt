package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.Default
import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.season.gameweek.GameWeek
import org.oriolbellet.football.domain.season.gameweek.GameWeeksGeneratorProvider
import org.oriolbellet.football.domain.team.Team
import java.util.*

class Season(val gameWeeks: List<GameWeek>, val teams: List<Team>, var currentWeek: Int = 0) {

    var seasonId: UUID? = null

    @Default
    constructor(seasonId: UUID, gameWeeks: List<GameWeek>, teams: List<Team>, currentWeek: Int) : this(
        gameWeeks,
        teams,
        currentWeek
    ) {
        this.seasonId = seasonId
    }

    constructor(teams: List<Team>, gameWeeksGeneratorProvider: GameWeeksGeneratorProvider) : this(
        gameWeeksGeneratorProvider(teams.size)(teams),
        teams
    )

    fun playCurrentWeek(matchAlgorithm: MatchAlgorithm) {
        gameWeeks[this.currentWeek++].play(matchAlgorithm)
    }

    fun getLastGameWeek(): GameWeek {
        return gameWeeks[currentWeek - 1]
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Season

        if (gameWeeks != other.gameWeeks) return false
        if (teams != other.teams) return false
        if (currentWeek != other.currentWeek) return false
        if (seasonId != other.seasonId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gameWeeks.hashCode()
        result = 31 * result + teams.hashCode()
        result = 31 * result + currentWeek
        result = 31 * result + (seasonId?.hashCode() ?: 0)
        return result
    }


}