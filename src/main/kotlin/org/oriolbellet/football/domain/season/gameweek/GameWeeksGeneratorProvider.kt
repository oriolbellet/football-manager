package org.oriolbellet.football.domain.season.gameweek

import org.oriolbellet.football.domain.season.gameweek.GameWeeksGenerator

interface GameWeeksGeneratorProvider {

    operator fun invoke(numTeams: Int): GameWeeksGenerator

}