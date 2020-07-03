package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.team.LineUp

interface PossessionCalculator {

    operator fun invoke(homeTeamLineUp: LineUp, awayTeamLineUp: LineUp): MatchTeams

}