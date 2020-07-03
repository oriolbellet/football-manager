package org.oriolbellet.football.adapter.`in`.player

import org.oriolbellet.football.adapter.`in`.PlayerDto
import org.oriolbellet.football.adapter.`in`.mapping.PlayerDtoMapper
import org.oriolbellet.football.application.port.`in`.GetPlayerUseCase
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/football/api/v1/players")
class GetPlayerController(private val getPlayerUseCase: GetPlayerUseCase,
                          private val playerDtoMapper: PlayerDtoMapper) {

    @GetMapping("/{playerId}")
    fun getPlayer(@PathVariable("playerId") playerId: String): PlayerDto {

        val player = this.getPlayerUseCase(playerId)

        return this.playerDtoMapper(player)

    }


}