package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.team.LineUp

interface MatchAlgorithm {

    fun play(homeTeamLineUp: LineUp, awayTeamLineUp: LineUp): Score


}