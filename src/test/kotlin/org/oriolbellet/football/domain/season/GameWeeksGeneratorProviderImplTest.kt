package org.oriolbellet.football.domain.season

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.domain.season.gameweek.GameWeeksGenerator
import org.oriolbellet.football.domain.season.gameweek.GameWeeksGeneratorProviderImpl
import java.lang.IllegalArgumentException

@ExtendWith(MockitoExtension::class)
internal class GameWeeksGeneratorProviderImplTest {

    @Mock
    lateinit var gameWeeks4TeamGenerator: GameWeeksGenerator

    private lateinit var gameWeeksGeneratorProviderImpl: GameWeeksGeneratorProviderImpl

    @BeforeEach
    fun setUp() {
        gameWeeksGeneratorProviderImpl = GameWeeksGeneratorProviderImpl(gameWeeks4TeamGenerator)
    }

    @Test
    fun `when invoke if number of teams is 4 then must return gameWeeks4Generator`() {
        //When + Then
        assertEquals(gameWeeks4TeamGenerator, gameWeeksGeneratorProviderImpl(4))
    }

    @Test
    fun `when invoke if number of teams is not 4 then must throw IllegalArgumentException`() {
        //When + Then
        assertThrows<IllegalArgumentException> { (gameWeeksGeneratorProviderImpl(3)) }
    }
}