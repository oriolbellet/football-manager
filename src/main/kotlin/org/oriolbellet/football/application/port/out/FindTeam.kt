package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.team.Team
import java.util.*

interface FindTeam {

    fun findTeamById(teamId: UUID): Optional<Team>

}