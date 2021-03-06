package org.oriolbellet.football.domain.player

import java.util.*

interface FindPlayerDomainService {

    operator fun invoke(playerId: UUID): Player

}