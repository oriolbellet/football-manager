package org.oriolbellet.football.domain.game

import org.oriolbellet.football.adapter.out.model.Default
import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.domain.season.GameWeek
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.Team
import java.util.*


class Game(val gameTeams: List<Team>, val userTeam: Team, val season: Season) {

    var gameId: UUID? = null

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
}