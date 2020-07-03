package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Match

interface CreateMatchUseCase {

    operator fun invoke(homeTeamId: String, awayTeamId: String): Match

}