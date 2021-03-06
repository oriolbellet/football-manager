package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.player.Player

interface SavePlayer {
    fun save(player: Player): Player
}