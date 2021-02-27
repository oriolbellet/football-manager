package org.oriolbellet.football.domain.season

interface GameWeeksGeneratorProvider {

    operator fun invoke(numTeams: Int): GameWeeksGenerator

}