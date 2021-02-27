package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindTeam
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.inject.Named

@Named
class TeamAdapter(private val teamDao: TeamDao) : FindTeam, FindTeams, SaveTeam {

    override fun findTeamById(teamId: UUID): Optional<Team> {
        return teamDao.findById(teamId)
    }

    override fun findAllDefaultTeams(): List<Team> {
        return teamDao.findByDefaultTrue()
    }

    override fun save(team: Team): Team {
        return teamDao.save(team)
    }
}