package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.match.Score

interface PlayedMatchUseCase {

    operator fun invoke(matchId: Long, score: Score)

}