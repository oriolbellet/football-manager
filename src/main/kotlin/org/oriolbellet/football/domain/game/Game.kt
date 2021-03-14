package org.oriolbellet.football.domain.game

import org.oriolbellet.football.adapter.out.model.Default
import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.season.gameweek.GameWeek
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.Team
import java.util.*


class Game(val gameTeams: List<Team>, val userTeam: Team, val season: Season) {

    var gameId: UUID? = null

    init {
        if (!gameTeams.contains(userTeam)) {
            //TODO throw IllegalArgumentException()
        }
    }

    @Default
    constructor(gameId: UUID, gameTeams: List<Team>, userTeam: Team, season: Season) : this(
        gameTeams,
        userTeam,
        season
    ) {
        this.gameId = gameId
    }

    fun play(matchAlgorithm: MatchAlgorithm) {
        season.playCurrentWeek(matchAlgorithm)
    }

    fun lastGameWeek(): GameWeek {
        return season.getLastGameWeek()
    }

    fun gameWeeksFromFirstToLastPlayed(): List<GameWeek> {
        return season.gameWeeks.subList(0, season.currentWeek)
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Game

        if (gameTeams != other.gameTeams) return false
        if (userTeam != other.userTeam) return false
        if (season != other.season) return false
        if (gameId != other.gameId) return false

        return true
    }

    override fun hashCode(): Int {
        var result = gameTeams.hashCode()
        result = 31 * result + userTeam.hashCode()
        result = 31 * result + season.hashCode()
        result = 31 * result + (gameId?.hashCode() ?: 0)
        return result
    }


}