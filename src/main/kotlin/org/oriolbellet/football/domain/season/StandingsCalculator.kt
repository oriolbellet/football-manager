package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.team.Team

interface StandingsCalculator {

    operator fun invoke(teams: List<Team>, gameWeeks: List<GameWeek>): List<StandingRow>

}