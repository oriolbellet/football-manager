package org.oriolbellet.football.domain.season.standings

import org.oriolbellet.football.domain.season.gameweek.GameWeek
import org.oriolbellet.football.domain.season.standings.StandingRow
import org.oriolbellet.football.domain.team.Team

interface StandingsCalculator {

    operator fun invoke(teams: List<Team>, gameWeeks: List<GameWeek>): List<StandingRow>

}