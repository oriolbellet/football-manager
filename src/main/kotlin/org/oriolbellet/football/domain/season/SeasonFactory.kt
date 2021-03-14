package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.team.Team

interface SeasonFactory {
    fun create(teams: List<Team>): Season
}