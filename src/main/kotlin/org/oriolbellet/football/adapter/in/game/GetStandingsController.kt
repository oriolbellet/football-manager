package org.oriolbellet.football.adapter.`in`.game

import org.oriolbellet.football.adapter.`in`.StandingRowDto
import org.oriolbellet.football.adapter.`in`.mapping.StandingRawDtoMapper
import org.oriolbellet.football.application.port.`in`.GetStandingsUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class GetStandingsController(
    private val getStandingsUseCase: GetStandingsUseCase,
    private val standingRawDtoMapper: StandingRawDtoMapper
) {

    @GetMapping("{gameId}/standings")
    fun getStandings(@PathVariable("gameId") gameId: UUID): List<StandingRowDto> {
        return this.getStandingsUseCase(gameId).map {
            this.standingRawDtoMapper(it)
        }
    }
}