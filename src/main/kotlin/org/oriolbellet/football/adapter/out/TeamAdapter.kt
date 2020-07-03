package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindTeam
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.inject.Inject
import javax.inject.Named

@Named
class TeamAdapter(@Inject private val teamDao: TeamDao): FindTeam, FindTeams {

    override fun findTeamById(teamId: String): Optional<Team> {

        return this.teamDao.findById(teamId)

    }

    override fun findAll(): List<Team> {

        return this.teamDao.findAll()

    }
}