package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.team.Team

interface SaveTeam {
    fun save(team: Team): Team
}