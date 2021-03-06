package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.adapter.out.model.CycleAvoidingMappingContext
import org.oriolbellet.football.adapter.out.model.TeamMapper
import org.oriolbellet.football.application.port.out.FindTeam
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.application.port.out.SaveTeam
import org.oriolbellet.football.domain.team.Team
import java.util.*
import javax.inject.Named

@Named
class TeamAdapter(
    private val teamDao: TeamDao,
    private val teamMapper: TeamMapper
) : FindTeam, FindTeams, SaveTeam {

    override fun findTeamById(teamId: UUID): Optional<Team> {
        val findById = teamDao.findById(teamId)
        return if (!findById.isPresent) {
            Optional.empty()
        } else {
            Optional.of(teamMapper.toTeam(findById.get(), CycleAvoidingMappingContext()))
        }
    }

    override fun findAllDefaultTeams(): List<Team> {
        val findById = teamDao.findByDefTrue()
        return findById.map {
            teamMapper.toTeam(it, CycleAvoidingMappingContext())
        }.toList()
    }

    override fun save(team: Team): Team {
        val gameDataEntity = teamMapper.toTeamDataEntity(team, CycleAvoidingMappingContext())
        return teamMapper.toTeam(teamDao.save(gameDataEntity), CycleAvoidingMappingContext())
    }
}