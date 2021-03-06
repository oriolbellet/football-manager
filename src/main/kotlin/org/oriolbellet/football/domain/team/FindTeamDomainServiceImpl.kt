package org.oriolbellet.football.domain.team

import org.oriolbellet.football.application.port.out.FindTeam
import org.oriolbellet.football.error.ErrorCode
import org.oriolbellet.football.error.NotFoundException
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class FindTeamDomainServiceImpl(private val findTeam: FindTeam) : FindTeamDomainService {

    override fun invoke(teamId: UUID): Team {
        return this.findTeam.findTeamById(teamId).orElseThrow {
            NotFoundException(ErrorCode.TEAM_NOT_FOUND, "Team with id $teamId not found")
        }
    }

}