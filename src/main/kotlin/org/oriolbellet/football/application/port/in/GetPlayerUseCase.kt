package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.player.Player
import java.util.*

interface GetPlayerUseCase {

    operator fun invoke(playerId: UUID): Player

}