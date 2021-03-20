package org.oriolbellet.football.domain.season.gameweek

import org.oriolbellet.football.commons.NAMED_GAME_WEEK_4_TEAMS_GENERATOR
import javax.inject.Named

@Named
class GameWeeksGeneratorProviderImpl(@Named(NAMED_GAME_WEEK_4_TEAMS_GENERATOR) private val gameWeeks4TeamGenerator: GameWeeksGenerator) :
    GameWeeksGeneratorProvider {

    override fun invoke(numTeams: Int): GameWeeksGenerator {

        if (numTeams == 4) {
            return gameWeeks4TeamGenerator
        }

        throw IllegalArgumentException("Cannot generate game weeks for $numTeams teams")

    }
}