package org.oriolbellet.football.application.service

import org.oriolbellet.football.application.port.`in`.CreateMatchUseCase
import org.oriolbellet.football.application.port.out.SaveMatch
import org.oriolbellet.football.domain.match.Match
import org.oriolbellet.football.domain.team.FindTeamDomainService
import java.util.*
import javax.inject.Named
import javax.transaction.Transactional

@Named
open class CreateMatchService(
    private val findTeamDomainService: FindTeamDomainService,
    private val saveMatch: SaveMatch
) : CreateMatchUseCase {

    @Transactional
    override fun invoke(homeTeamId: UUID, awayTeamId: UUID): Match {

        val homeTeam = this.findTeamDomainService(homeTeamId)

        val awayTeam = this.findTeamDomainService(awayTeamId)

        val match = Match(homeTeam, awayTeam)

        return this.saveMatch.save(match)
    }
}