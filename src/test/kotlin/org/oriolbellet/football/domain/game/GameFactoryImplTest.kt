package org.oriolbellet.football.domain.game

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.season.SeasonFactory
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class GameFactoryImplTest {

    companion object {
        private val team1Id: UUID = UUID.fromString("1365d2b6-23c4-4fb9-ba8a-1998c4ff14b7")
        private val team1 = Team(team1Id, "team1", emptyList(), LineUp(tactic = BasicTactics.T343), false)
        val teams = mutableListOf(team1)
    }

    @Mock
    lateinit var seasonFactory: SeasonFactory

    lateinit var gameFactoryImpl: GameFactoryImpl

    @BeforeEach
    fun setUp() {
        gameFactoryImpl = GameFactoryImpl(seasonFactory)
    }

    @Test
    fun `when create then a new Game is created`() {
        //Given
        val season = Season(gameWeeks = emptyList(), teams = teams)
        `when`(seasonFactory.create(teams)).thenReturn(season)

        //When + Then
        assertDoesNotThrow {
            gameFactoryImpl.create(teams, team1)
        }
    }
}