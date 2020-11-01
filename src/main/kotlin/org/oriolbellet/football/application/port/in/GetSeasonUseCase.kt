package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.season.StandingRow

interface GetSeasonUseCase {

    operator fun invoke(): Season

}