package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.LineUp

interface GetLineUpUseCase {

    operator fun invoke(teamId: String): LineUp

}