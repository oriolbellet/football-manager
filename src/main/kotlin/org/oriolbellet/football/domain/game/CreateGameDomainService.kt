package org.oriolbellet.football.domain.game

import org.oriolbellet.football.domain.team.Team
import java.util.*

interface CreateGameDomainService {
    operator fun invoke(defaultTeams: List<Team>, defaultUserTeamId: UUID): Game
}