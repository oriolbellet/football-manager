package org.oriolbellet.football.application.service

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.oriolbellet.football.application.port.out.FindTeam
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@ContextConfiguration(classes = [GetTeamsService::class])
internal class GetTeamsServiceTest {

    @Autowired
    private lateinit var getTeamsService: GetTeamsService


    @Test
    fun `when getAll should return all teams`() {

        //TODO

    }



}