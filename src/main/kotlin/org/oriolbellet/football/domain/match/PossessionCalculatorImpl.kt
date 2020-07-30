package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.match.MatchTeams.AWAY_TEAM
import org.oriolbellet.football.domain.match.MatchTeams.HOME_TEAM
import org.oriolbellet.football.domain.team.LineUp
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Named

@Named
class PossessionCalculatorImpl: PossessionCalculator {

    override fun invoke(homeTeamLineUp: LineUp, awayTeamLineUp: LineUp): MatchTeams {

        val homeTeamPoints = homeTeamLineUp.getMidfieldPoints()
        val awayTeamPoints = awayTeamLineUp.getMidfieldPoints()

        val bound = homeTeamPoints + awayTeamPoints

        val random = ThreadLocalRandom.current().nextInt(1, bound)

        return if (random <= homeTeamPoints) HOME_TEAM else AWAY_TEAM

    }
}