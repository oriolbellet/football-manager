package org.oriolbellet.football.componenttests

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.oriolbellet.football.adapter.`in`.GameDto
import org.oriolbellet.football.adapter.`in`.game.CreateGameController
import org.oriolbellet.football.adapter.out.persistence.game.GameDao
import org.oriolbellet.football.error.ErrorCode.INVALID_TEAM
import org.oriolbellet.football.error.ErrorDto
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import java.util.*
import javax.inject.Inject

@SpringBootTest
@AutoConfigureMockMvc
class CreateGameComponentTest {

    @Inject
    lateinit var mvc: MockMvc

    @Inject
    lateinit var gameDao: GameDao

    @Test
    fun `when create game then created game exists in the DB`() {
        //Given
        val createGameDto = CreateGameController.CreateGameDto(UUID.fromString("cb743f64-20fb-443a-96b0-aebc0f47d6e1"))

        //When
        val body = mvc.perform(
            post("/football/api/v1/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Json.encodeToString(createGameDto))
        )
            .andExpect(status().isOk)
            .andReturn()
            .response
            .contentAsString

        //Then
        val response = Json.decodeFromString<GameDto>(body)
        assertTrue(gameDao.findById(response.gameId).isPresent)
    }

    @Test
    fun `when create game and userTeamId does not exist then must return error`() {
        //Given
        val createGameDto = CreateGameController.CreateGameDto(UUID.fromString("cb743f64-20fb-443a-96b0-aebc0f47d6e0"))

        //When
        val body = mvc.perform(
            post("/football/api/v1/games")
                .contentType(MediaType.APPLICATION_JSON)
                .content(Json.encodeToString(createGameDto))
        )
            .andExpect(status().isBadRequest)
            .andReturn()
            .response
            .contentAsString

        //Then
        val response = Json.decodeFromString<ErrorDto>(body)
        assertEquals(INVALID_TEAM, response.errorCode)
    }
}