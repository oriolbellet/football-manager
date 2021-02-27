package org.oriolbellet.football.domain.season

import javax.inject.Named

@Named
class GameWeeksGeneratorProviderImpl(private val gameWeeks4TeamGenerator: GameWeeks4TeamGenerator) :
    GameWeeksGeneratorProvider {

    override fun invoke(numTeams: Int): GameWeeksGenerator {

        if (numTeams == 4) {
            return gameWeeks4TeamGenerator
        }

        throw IllegalArgumentException("Cannot generate game weeks for $numTeams teams")

    }
}