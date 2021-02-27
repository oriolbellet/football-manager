package org.oriolbellet.football.domain.player

interface FindPlayerDomainService {

    operator fun invoke(playerId: String): Player

}