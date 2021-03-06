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
internal class TeamDataEntityAdapterTest {

    @MockBean
    private lateinit var teamDao: TeamDao

    @Autowired
    private lateinit var teamAdapter: TeamAdapter

    private fun <T> any(type: Class<T>): T = Mockito.any(type)

    @Test
    fun `when findByTeamId should return Team`() {


        //assertEquals(name, team.name)

    }


}