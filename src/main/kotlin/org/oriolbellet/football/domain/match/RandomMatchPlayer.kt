package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.match.MatchPlayer
import org.oriolbellet.football.domain.match.Score
import org.oriolbellet.football.domain.team.LineUp
import java.util.concurrent.ThreadLocalRandom

class RandomMatchPlayer: MatchPlayer {

    override fun play(homeTeamLineUp: LineUp, awayTeamLineUp: LineUp): Score {

        return Score(this.calculateScore(), this.calculateScore())

    }

    private fun calculateScore(): Int {

        return ThreadLocalRandom.current().nextInt(0, 6)

    }


}