package org.oriolbellet.football.domain.team

import org.oriolbellet.football.domain.team.Team

interface FindTeamDomainService {

    operator fun invoke(teamId: String): Team

}
