package org.oriolbellet.football.application.service

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.ArgumentMatchers.anyList
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify

import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.any
import org.oriolbellet.football.application.port.out.FindTeams
import org.oriolbellet.football.application.port.out.SaveGame
import org.oriolbellet.football.capture
import org.oriolbellet.football.domain.game.CreateGameDomainService
import org.oriolbellet.football.domain.game.Game
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.eq
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class CreateGameServiceTest {

    private val uuid = UUID.fromString("a93724e5-d7ff-43e3-a22a-d85380f63400")
    private val team = Team(name = "team1", emptyList(), LineUp(tactic = BasicTactics.T343))
    private val game = Game(uuid, emptyList(), team, Season(uuid, emptyList(), emptyList(), 0))

    @Mock
    private lateinit var findTeams: FindTeams

    @Mock
    private lateinit var saveGame: SaveGame

    @Mock
    private lateinit var createGameDomainService: CreateGameDomainService

    @Captor
    private lateinit var gameArgumentCaptor: ArgumentCaptor<Game>

    @Captor
    private lateinit var teamsArgumentCaptor: ArgumentCaptor<List<Team>>

    private lateinit var createGameService: CreateGameService

    @BeforeEach
    fun setUp() {
        createGameService = CreateGameService(findTeams, saveGame, createGameDomainService)
    }

    @Test
    fun `when invoke then must return same object as saveGame`() {
        //Given
        `when`(findTeams.findAllDefault()).thenReturn(Collections.singletonList(team))
        `when`(createGameDomainService(anyList(), any())).thenReturn(game)
        `when`(saveGame.save(any())).thenReturn(game)

        //When
        val createdGame = createGameService(uuid)

        //Then
        assertEquals(createdGame, game)
    }

    @Test
    fun `when invoke then createGameDomainServer must be called`() {
        //Given
        `when`(findTeams.findAllDefault()).thenReturn(Collections.singletonList(team))
        `when`(saveGame.save(any())).thenReturn(game)

        //When
        createGameService(uuid)

        //Then
        verify(createGameDomainService)(capture(teamsArgumentCaptor), eq(uuid))
        assertTrue(teamsArgumentCaptor.value.contains(team))
        assertEquals(1, teamsArgumentCaptor.value.size)
    }

    @Test
    fun `when invoke then saveGame must be called`() {
        //Given
        `when`(findTeams.findAllDefault()).thenReturn(Collections.singletonList(team))
        `when`(createGameDomainService(anyList(), any())).thenReturn(game)

        //When
        createGameService(uuid)

        //Then
        verify(saveGame).save(capture(gameArgumentCaptor))
        assertEquals(game, gameArgumentCaptor.value)
    }
}