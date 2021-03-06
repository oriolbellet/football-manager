package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetPlayerUseCase
import org.oriolbellet.football.application.port.out.FindPlayer
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.error.ErrorCode.PLAYER_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class GetPlayerService(private val findPlayer: FindPlayer): GetPlayerUseCase {

    override fun invoke(playerId: UUID): Player {
        return this.findPlayer.find(playerId).orElseThrow {
            NotFoundException(PLAYER_NOT_FOUND, "Player with id $playerId not found")
        }
    }
}