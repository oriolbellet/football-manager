package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.PlayMatchUseCase
import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.application.port.out.PlayMatch
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.match.MatchAlgorithm
import org.oriolbellet.football.error.ErrorCode.MATCH_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Named
import javax.transaction.Transactional

@Named("playMatchService")
open class PlayMatchService(
    private val findMatch: FindMatch,
    private val saveMatch: SaveMatch,
    private val matchAlgorithm: MatchAlgorithm,
    private val playMatch: PlayMatch
) : PlayMatchUseCase {

    @Transactional
    override fun invoke(matchId: Long): Match {

        val match = this.findMatch.findMatchById(matchId).orElseThrow {
            NotFoundException(MATCH_NOT_FOUND, "Match with id $matchId not found")
        }

        playMatch(match)

        match.play(this.matchAlgorithm)

        return this.saveMatch.save(match)

    }
}