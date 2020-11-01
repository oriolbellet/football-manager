package org.oriolbellet.football.adapter.`in`.season

import org.oriolbellet.football.adapter.`in`.SeasonDto
import org.oriolbellet.football.adapter.`in`.mapping.SeasonDtoMapper
import org.oriolbellet.football.application.port.`in`.GetSeasonUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/season")
class GetSeasonController(private val getSeasonUseCase: GetSeasonUseCase,
                          private val seasonDtoMapper: SeasonDtoMapper) {

    @GetMapping
    fun getSeason (): SeasonDto {

        val season = this.getSeasonUseCase()

        return this.seasonDtoMapper(season)

    }

}