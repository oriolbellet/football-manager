package org.oriolbellet.football.adapter.out

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mockito
import org.mockito.Mockito.`when`
import org.oriolbellet.football.domain.team.Team
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension
import java.util.*

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [TeamAdapter::class])
internal class TeamAdapterTest {

    @MockBean
    private lateinit var teamDao: TeamDao

    @Autowired
    private lateinit var teamAdapter: TeamAdapter

    private fun <T> any(type: Class<T>): T = Mockito.any(type)

    @Test
    fun `when findByTeamId should return Team`() {

        //Given
        val teamId = UUID.randomUUID().toString()
        val name = UUID.randomUUID().toString()
        var teamJpaEntity = Team()
        teamJpaEntity.name = name
        teamJpaEntity.teamId = teamId

        `when`(this.teamDao.findById(any(String::class.java))).thenReturn(Optional.of(teamJpaEntity))

        //When
        this.teamAdapter.findTeamById(teamId)

        //Then
        //assertEquals(name, team.name)

    }


}