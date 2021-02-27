package org.oriolbellet.football.domain.game

import java.util.*

interface FindGameDomainService {

    operator fun invoke(gameId: UUID): Game

}