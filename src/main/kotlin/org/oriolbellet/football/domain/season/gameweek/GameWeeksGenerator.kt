package org.oriolbellet.football.domain.season.gameweek

import org.oriolbellet.football.domain.team.Team

interface GameWeeksGenerator {
    operator fun invoke(teams: List<Team>): List<GameWeek>
}
