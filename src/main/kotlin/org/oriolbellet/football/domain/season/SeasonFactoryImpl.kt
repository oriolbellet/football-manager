package org.oriolbellet.football.domain.season

import org.oriolbellet.football.domain.season.gameweek.GameWeeksGeneratorProvider
import org.oriolbellet.football.domain.team.Team
import javax.inject.Named

@Named
class SeasonFactoryImpl(private val gameWeeksGeneratorProvider: GameWeeksGeneratorProvider) : SeasonFactory {
    override fun create(teams: List<Team>): Season {
        return Season(teams, gameWeeksGeneratorProvider)
    }
}