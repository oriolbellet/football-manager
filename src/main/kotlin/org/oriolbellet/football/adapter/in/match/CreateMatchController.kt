package org.oriolbellet.football.adapter.`in`.match

import org.oriolbellet.football.adapter.`in`.MatchDto
import org.oriolbellet.football.adapter.`in`.mapping.MatchDtoMapper
import org.oriolbellet.football.application.port.`in`.CreateMatchUseCase
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/matches")
class CreateMatchController(
    private val createMatchUseCase: CreateMatchUseCase,
    private val matchDtoMapper: MatchDtoMapper
) {

    @PostMapping
    fun createMatch(@RequestBody createMatchRequestDto: CreateMatchRequestDto): MatchDto {
        val match = this.createMatchUseCase(createMatchRequestDto.homeTeamId, createMatchRequestDto.awayTeamId)
        return this.matchDtoMapper(match)
    }

    data class CreateMatchRequestDto(val homeTeamId: UUID, val awayTeamId: UUID)
}