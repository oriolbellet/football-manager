package org.oriolbellet.football.adapter.`in`.season

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.adapter.`in`.SeasonDto
import org.oriolbellet.football.adapter.`in`.mapping.MatchDtoMapper
import org.oriolbellet.football.adapter.`in`.mapping.SeasonDtoMapper
import org.oriolbellet.football.application.port.`in`.GetSeasonUseCase
import org.oriolbellet.football.application.port.`in`.PlayGameWeekUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/season")
class PlaySeasonController(private val playGameWeekUseCase: PlayGameWeekUseCase,
                           private val matchDtoMapper: MatchDtoMapper) {

    @PostMapping
    fun getSeason (): List<MatchDto> {

        return this.playGameWeekUseCase().matches.map {
            this.matchDtoMapper(it)
        }

    }

}