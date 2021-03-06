package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.LineUp
import java.util.*

interface SubstitutionUseCase {
    operator fun invoke(gameId: UUID, player1Id: UUID, player2Id: UUID): LineUp
}