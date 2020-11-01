package org.oriolbellet.football.adapter.`in`.season

import org.oriolbellet.football.adapter.`in`.StandingRowDto
import org.oriolbellet.football.adapter.`in`.mapping.StandingRawDtoMapper
import org.oriolbellet.football.application.port.`in`.GetStandingsUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/season/standings")
class GetStandingsController(private val getStandingsUseCase: GetStandingsUseCase,
                             private val standingRawDtoMapper: StandingRawDtoMapper) {

    @GetMapping
    fun getStandings(): List<StandingRowDto> {

        return this.getStandingsUseCase().map {
            this.standingRawDtoMapper(it)
        }

    }

}