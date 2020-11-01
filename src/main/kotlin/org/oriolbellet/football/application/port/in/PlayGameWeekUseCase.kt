package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.season.GameWeek

interface PlayGameWeekUseCase {

    operator fun invoke(): GameWeek

}