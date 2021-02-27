package org.oriolbellet.football.domain.team

import java.util.*

interface FindTeamDomainService {

    operator fun invoke(teamId: UUID): Team

}
