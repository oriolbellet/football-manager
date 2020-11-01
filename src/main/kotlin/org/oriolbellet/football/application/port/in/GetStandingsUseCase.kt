package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.season.StandingRow

interface GetStandingsUseCase {

    operator fun invoke(): List<StandingRow>

}