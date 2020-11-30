package org.oriolbellet.football.adapter.`in`.match

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.adapter.`in`.mapping.MatchDtoMapper
import org.oriolbellet.football.application.port.`in`.PlayMatchUseCase
import org.springframework.beans.factory.annotation.Qualifier
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/matches")
class PlayMatchController(@Qualifier("producePlayMatch") private val playMatchUseCase: PlayMatchUseCase,
                          private val matchDtoMapper: MatchDtoMapper) {

    @PostMapping("/{matchId}")
    fun playMatch(@PathVariable("matchId") matchId: Long): MatchDto {

        val match = playMatchUseCase(matchId)

        return matchDtoMapper(match)

    }

}