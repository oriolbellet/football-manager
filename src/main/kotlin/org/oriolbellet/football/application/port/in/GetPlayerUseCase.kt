package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.player.Player

interface GetPlayerUseCase {

    operator fun invoke(playerId: String): Player

}