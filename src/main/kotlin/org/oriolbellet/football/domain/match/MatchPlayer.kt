package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.match.Score
import org.oriolbellet.football.domain.team.LineUp

interface MatchPlayer {

    fun play(homeTeamLineUp: LineUp, awayTeamLineUp: LineUp): Score


}