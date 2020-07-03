package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.PlayMatchUseCase
import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchPlayer
import org.oriolbellet.football.error.ErrorCode.MATCH_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Named

@Named
class PlayMatchService(private val findMatch: FindMatch,
                       private val saveMatch: SaveMatch,
                       private val matchPlayer: MatchPlayer): PlayMatchUseCase {

    override fun invoke(matchId: Long): Match {

        val match = this.findMatch.findMatchById(matchId).orElseThrow{
            NotFoundException(MATCH_NOT_FOUND, "Match with id $matchId not found")
        }

        match.play(this.matchPlayer)

        return this.saveMatch.save(match)

    }
}