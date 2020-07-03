package org.oriolbellet.football.adapter.out

import org.oriolbellet.football.application.port.out.FindLineup
import org.oriolbellet.football.domain.team.LineUp
import javax.inject.Inject
import javax.inject.Named

@Named
class LineupAdapter(@Inject private val teamDao: TeamDao): FindLineup {

    override fun findLineupById(teamId: String): LineUp {

        return this.teamDao.findById(teamId).get().lineUp

    }
}