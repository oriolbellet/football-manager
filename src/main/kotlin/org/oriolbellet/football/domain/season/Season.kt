package org.oriolbellet.football.domain.season

import org.oriolbellet.football.adapter.out.model.Default
import org.oriolbellet.football.domain.match.MatchAlgorithm
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
}