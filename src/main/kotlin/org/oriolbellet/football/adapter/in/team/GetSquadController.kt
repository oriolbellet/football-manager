package org.oriolbellet.football.adapter.`in`.team

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.application.port.`in`.GetSquadUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/teams")
class GetSquadController(private val getSquadUseCase: GetSquadUseCase,
                         private val playerDtoMapper: PlayerDtoMapper) {

    @GetMapping("/{teamId}/squad")
    fun getSquad(@PathVariable("teamId") teamId: UUID): List<PlayerDto> {

        val squad = this.getSquadUseCase(teamId)

        return squad.map { this.playerDtoMapper(it) }

    }

}