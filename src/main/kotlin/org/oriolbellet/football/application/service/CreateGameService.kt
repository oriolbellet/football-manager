package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.CreateGameUseCase
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.domain.game.CreateGameDomainService
import org.oriolbellet.football.domain.game.Game
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class CreateGameService(
    private val findTeams: FindTeams,
    private val saveGame: SaveGame,
    private val createGameDomainService: CreateGameDomainService
) : CreateGameUseCase {

    @Transactional
    override fun invoke(userTeamId: UUID): Game {
        val teams = findTeams.findAllDefault()
        val game = createGameDomainService(teams, userTeamId)
        return saveGame.save(game)
    }
}
