package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindPlayer
import org.oriolbellet.football.domain.player.Player
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class PlayerAdapter(@Inject private val playerDao: PlayerDao): FindPlayer {

    override fun findPlayerById(playerId: String): Optional<Player> {

        return this.playerDao.findById(playerId)

    }

}