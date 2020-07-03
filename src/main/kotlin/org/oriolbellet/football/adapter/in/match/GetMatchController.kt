package org.oriolbellet.football.adapter.`in`.match

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.adapter.`in`.mapping.MatchDtoMapper
import org.oriolbellet.football.application.port.`in`.GetMatchUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/matches")
class GetMatchController(private val getMatchUseCase: GetMatchUseCase,
                         private val matchDtoMapper: MatchDtoMapper) {

    @GetMapping("/{matchId}")
    fun getMatch(@PathVariable("matchId") matchId: Long): MatchDto {

        val match = this.getMatchUseCase(matchId)

        return this.matchDtoMapper(match)

    }

}