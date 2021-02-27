package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindPlayer
import org.oriolbellet.football.domain.player.Player
import java.util.*
import javax.inject.Named

@Named
class PlayerAdapter(private val playerDao: PlayerDao) : FindPlayer {

    override fun find(playerId: String): Optional<Player> {
        return this.playerDao.findById(playerId)
    }

}