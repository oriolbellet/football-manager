package org.oriolbellet.football.adapter.out.persistence.game

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.Mockito.verify
import org.mockito.junit.jupiter.MockitoExtension
import org.oriolbellet.football.adapter.out.persistence.lineup.LineUpDataEntity
import org.oriolbellet.football.adapter.out.persistence.team.TeamDataEntity
import org.oriolbellet.football.commons.mapping.MapperWrapper
import org.oriolbellet.football.domain.game.Game
import org.oriolbellet.football.domain.season.Season
import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import org.oriolbellet.football.domain.team.Team
import java.util.*

@ExtendWith(MockitoExtension::class)
internal class GameAdapterTest {

    companion object {
        val game = Game(
            emptyList(),
            Team("", emptyList(), LineUp(tactic = BasicTactics.T343)),
            Season(gameWeeks = emptyList(), teams = emptyList())
        )
        val gameDataEntity = GameDataEntity(
            null,
            emptyList(),
            TeamDataEntity(null, "", emptyList(), LineUpDataEntity(null, emptyList(), BasicTactics.T343)),
            SeasonDataEntity(null, 0, emptyList(), emptyList())
        )
    }

    @Mock
    private lateinit var gameDao: GameDao

    @Mock
    private lateinit var mapperWrapper: MapperWrapper<Game, GameDataEntity>

    lateinit var gameAdapter: GameAdapter

    @BeforeEach
    fun setUp() {
        gameAdapter = GameAdapter(gameDao, mapperWrapper)
    }

    @Test
    fun `when save then GameDao must be called`() {
        //Given
        `when`(mapperWrapper.toData(game)).thenReturn(gameDataEntity)
        `when`(gameDao.save(gameDataEntity)).thenReturn(gameDataEntity)
        `when`(mapperWrapper.toDomain(gameDataEntity)).thenReturn(game)

        //When
        val createdGame = gameAdapter.save(game)

        //Then
        verify(gameDao).save(gameDataEntity)
        assertEquals(game, createdGame)
    }

    @Test
    fun `when find and found then must return non empty`() {
        //Given
        val gameId = UUID.fromString("30096ac1-4310-45bf-b1b7-b094dd4d2413")
        `when`(gameDao.findById(gameId)).thenReturn(Optional.of(gameDataEntity))
        `when`(mapperWrapper.toDomain(gameDataEntity)).thenReturn(game)

        //When + Then
        assertTrue(gameAdapter.find(gameId).isPresent)
    }

    @Test
    fun `when find and not found then must return empty`() {
        //Given
        val gameId = UUID.fromString("30096ac1-4310-45bf-b1b7-b094dd4d2413")
        `when`(gameDao.findById(gameId)).thenReturn(Optional.empty())

        //When + Then
        assertFalse(gameAdapter.find(gameId).isPresent)
    }
}
