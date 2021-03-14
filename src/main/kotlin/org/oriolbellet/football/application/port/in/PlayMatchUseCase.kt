package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Match

interface PlayMatchUseCase {

    operator fun invoke(matchId: Long): Match

}