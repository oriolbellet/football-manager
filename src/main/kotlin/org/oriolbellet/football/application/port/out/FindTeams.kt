package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.team.Team

interface FindTeams {

    fun findAll(): List<Team>

}