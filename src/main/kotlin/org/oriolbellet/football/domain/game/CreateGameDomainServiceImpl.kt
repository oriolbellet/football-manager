package org.oriolbellet.football.domain.game

import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Named

@Named
class CreateGameDomainServiceImpl(private val gameFactory: GameFactory) :
    CreateGameDomainService {

    override fun invoke(defaultTeams: List<Team>, defaultUserTeamId: UUID): Game {
        var userTeam: Team? = null
        val teams = defaultTeams.map {
            val team = Team(it)
            if (it.teamId == defaultUserTeamId) {
                userTeam = team
            }
            team
        }
        return gameFactory.create(
            teams,
            userTeam ?: throw NotFoundException(ErrorCode.TEAM_NOT_FOUND, "team $defaultUserTeamId not found")
        )
    }
}