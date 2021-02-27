package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.player.Player
import java.util.*

interface FindPlayer {

    fun find(playerId: String): Optional<Player>

}