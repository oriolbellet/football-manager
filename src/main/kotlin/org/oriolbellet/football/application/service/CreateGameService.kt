package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.CreateGameUseCase
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.application.port.out.SavePlayer
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.game.Game
import org.oriolbellet.football.domain.player.Player
import org.oriolbellet.football.domain.season.GameWeeksGeneratorProvider
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode.TEAM_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class CreateGameService(
    private val findTeams: FindTeams,
    private val saveGame: SaveGame,
    private val gameWeeksGeneratorProvider: GameWeeksGeneratorProvider,
) : CreateGameUseCase {

    override fun invoke(userTeamId: UUID): Game {

        var userTeam: Team? = null

        val teams = findTeams.findAllDefaultTeams().map {
            val team = createTeam(it)
            if (it.teamId == userTeamId) {
                userTeam = team
            }
            team
        }

        if (userTeam == null) {
            throw NotFoundException(TEAM_NOT_FOUND, "team with id $userTeamId not found")
        }

        val season = Season(teams, gameWeeksGeneratorProvider)

        val game = Game(teams, userTeam!!, season)

        return saveGame.save(game)
    }

    private fun createTeam(team: Team): Team {
        var newTeam = Team(name = team.name, lineUp = LineUp(tactic = team.lineUp.tactic))
        team.squad.forEach {
            newTeam.contractPlayer(Player(it))
        }
        return newTeam
    }
}
