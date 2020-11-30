package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.PlayedMatchUseCase
import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Score
import org.oriolbellet.football.error.ErrorCode.MATCH_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Named

@Named
class PlayedMatchService(private val findMatch: FindMatch,
                         private val saveMatch: SaveMatch): PlayedMatchUseCase {

    override fun invoke(matchId: Long, score: Score) {

        val match = this.findMatch.findMatchById(matchId).orElseThrow{
            NotFoundException(MATCH_NOT_FOUND, "Match with id $matchId not found")
        }

        match.played(score)

        this.saveMatch.save(match)

    }
}