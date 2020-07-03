package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.GetMatchUseCase
import org.oriolbellet.football.application.port.out.FindMatch
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.error.ErrorCode.MATCH_NOT_FOUND
import org.oriolbellet.football.error.NotFoundException
import javax.inject.Named

@Named
class GetMatchService(private val findMatch: FindMatch) : GetMatchUseCase {

    override fun invoke(matchId: Long): Match {
        return this.findMatch.findMatchById(matchId).orElseThrow {
            NotFoundException(MATCH_NOT_FOUND, "Match with id $matchId not found")
        }
    }
}