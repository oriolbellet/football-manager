package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.team.LineUp

interface FindLineup {

    fun findLineupById(teamId: String): LineUp

}