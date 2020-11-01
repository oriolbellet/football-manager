package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.season.GameWeek

interface PlayMatchUseCase {

    operator fun invoke(matchId: Long): Match

}