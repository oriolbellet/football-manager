package org.oriolbellet.football.domain.game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.ArgumentCaptor
import org.mockito.Captor
import org.mockito.Mock
import org.mockito.Mockito.verify
import org.mockito.Mockito.verifyNoInteractions
import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.capture
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import org.oriolbellet.football.error.NotFoundException
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class CreateGameDomainServiceImplTest {

    companion object {
        private val team1Id: UUID = UUID.fromString("1365d2b6-23c4-4fb9-ba8a-1998c4ff14b7")
        private val team2Id: UUID = UUID.fromString("1365d2b6-23c4-4fb9-ba8a-1998c4ff14b8")
        private val team1 = Team(team1Id, "team1", emptyList(), LineUp(tactic = BasicTactics.T343), false)
        private val team2 = Team(team2Id, "team2", emptyList(), LineUp(tactic = BasicTactics.T343), false)
        val teams = mutableListOf(team1, team2)
    }

    @Mock
    lateinit var gameFactory: GameFactory

    @Captor
    lateinit var teamsArgumentCaptor: ArgumentCaptor<List<Team>>

    @Captor
    lateinit var teamArgumentCaptor: ArgumentCaptor<Team>

    private lateinit var createGameDomainServiceImpl: CreateGameDomainServiceImpl

    @BeforeEach
    fun setUp() {
        createGameDomainServiceImpl = CreateGameDomainServiceImpl(gameFactory)
    }

    @Test
    fun `when invoke and exists a default team with userTeamId then game factory must be called`() {

        //When
        createGameDomainServiceImpl(teams, team1Id)

        //Then
        verify(gameFactory).create(capture(teamsArgumentCaptor), capture(teamArgumentCaptor))
        assertEquals(teams.size, teamsArgumentCaptor.value.size)
        assertTrue(teamsArgumentCaptor.value.contains(teamArgumentCaptor.value))
    }

    @Test
    fun `when invoke and does not exist a default team with userTeamId then NotFoundException is thrown`() {
        //Given
        val userTeamId = UUID.fromString("1365d2b6-23c4-4fb9-ba8a-1998c4ff14b9")

        //When + Then
        assertThrows<NotFoundException> { createGameDomainServiceImpl(teams, userTeamId) }
        verifyNoInteractions(gameFactory)
    }
}