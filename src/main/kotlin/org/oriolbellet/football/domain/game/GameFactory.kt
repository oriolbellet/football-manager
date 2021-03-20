package org.oriolbellet.football.domain.game

import org.oriolbellet.football.domain.team.Team

interface GameFactory {
    fun create(teams: List<Team>, userTeam: Team): Game
}