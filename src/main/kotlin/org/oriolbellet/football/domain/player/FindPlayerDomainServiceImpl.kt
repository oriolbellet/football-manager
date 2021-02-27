package org.oriolbellet.football.domain.player

import org.oriolbellet.football.application.port.out.FindPlayer
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class FindPlayerDomainServiceImpl(private val findPlayer: FindPlayer) : FindPlayerDomainService {

    override fun invoke(playerId: String): Player {
        return findPlayer.find(playerId).orElseThrow {
            NotFoundException(PLAYER_NOT_FOUND, "Player with id $playerId not found")
        }
    }
}