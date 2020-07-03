package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.domain.team.Team

interface GetSquadUseCase {

    operator fun invoke(teamId: String): List<Player>

}