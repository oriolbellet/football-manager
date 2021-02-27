package org.oriolbellet.football.application.port.`in`

import org.oriolbellet.football.domain.team.BasicTactics
import org.oriolbellet.football.domain.team.LineUp
import java.util.*

interface ChangeTacticUseCase {

    operator fun invoke(gameId: UUID, tactic: BasicTactics): LineUp

}