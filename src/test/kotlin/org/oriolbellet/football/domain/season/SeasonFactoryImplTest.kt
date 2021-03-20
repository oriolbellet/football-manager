package org.oriolbellet.football.domain.season

import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.domain.season.gameweek.GameWeeksGenerator
import org.oriolbellet.football.domain.season.gameweek.GameWeeksGeneratorProvider
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class SeasonFactoryImplTest {

    @Mock
    private lateinit var gameWeeksGeneratorProvider: GameWeeksGeneratorProvider

    @Mock
    private lateinit var gameWeeksGenerator: GameWeeksGenerator

    lateinit var seasonFactoryImpl: SeasonFactoryImpl

    @BeforeEach
    fun setUp() {
        seasonFactoryImpl = SeasonFactoryImpl(gameWeeksGeneratorProvider)
    }

    @Test
    fun `when create a new Season is created`() {

        //Given
        val team1 = Team(UUID.fromString("1365d2b6-23c4-4fb9-ba8a-1998c4ff14b7"), "team1", emptyList(), LineUp(tactic = BasicTactics.T343), false)
        val teams = mutableListOf(team1)
        `when`(gameWeeksGeneratorProvider(teams.size)).thenReturn(gameWeeksGenerator)
        `when`(gameWeeksGenerator(teams)).thenReturn(emptyList())

        //When
        assertDoesNotThrow {
            seasonFactoryImpl.create(teams)
        }
    }
}