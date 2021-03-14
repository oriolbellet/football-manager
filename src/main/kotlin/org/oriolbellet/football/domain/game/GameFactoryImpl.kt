package org.oriolbellet.football.domain.game

import org.oriolbellet.football.domain.season.SeasonFactory
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class GameFactoryImpl(private val seasonFactory: SeasonFactory) : GameFactory {
    override fun create(teams: List<Team>, userTeam: Team): Game {
        return Game(teams, userTeam, seasonFactory.create(teams))
    }
}