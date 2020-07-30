package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.team.LineUp

interface AttackSimulator {

    operator fun invoke(attackerLineUp: LineUp, defenderLineUp: LineUp): AttackResult

}