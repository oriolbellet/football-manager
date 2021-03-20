package org.oriolbellet.football.adapter.`in`.game

import kotlinx.serialization.Serializable
import org.oriolbellet.football.adapter.`in`.GameDto
import org.oriolbellet.football.adapter.`in`.mapping.GameDtoMapper
import org.oriolbellet.football.application.port.`in`.CreateGameUseCase
import org.oriolbellet.football.commons.UUIDSerializer
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RestController
@RequestMapping("/football/api/v1/games")
class CreateGameController(
    private val createGameUseCase: CreateGameUseCase,
    private val gameDtoMapper: GameDtoMapper
) {

    @PostMapping
    fun createGame(@RequestBody createGameDto: CreateGameDto): GameDto {
        return gameDtoMapper(createGameUseCase(createGameDto.userTeamId))
    }

    @Serializable
    data class CreateGameDto(@Serializable(with = UUIDSerializer::class) val userTeamId: UUID)

}