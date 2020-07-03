package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Match

interface GetMatchUseCase {

    operator fun invoke(matchId: Long): Match

}