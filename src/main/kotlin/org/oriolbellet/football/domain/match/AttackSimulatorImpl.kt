package org.oriolbellet.football.domain.match

import org.oriolbellet.football.domain.match.AttackResult.GOAL
import org.oriolbellet.football.domain.match.AttackResult.NO_GOAL
import org.oriolbellet.football.domain.team.LineUp
import java.util.concurrent.ThreadLocalRandom
import javax.inject.Named

@Named
class AttackSimulatorImpl: AttackSimulator {

    override fun invoke(attackerLineUp: LineUp, defenderLineUp: LineUp): AttackResult {

        val attackerPoints = attackerLineUp.getAttackPoints()
        val defenderPoints = defenderLineUp.getDefensePoints()

        val bound = attackerPoints + defenderPoints

        val random = ThreadLocalRandom.current().nextInt(1, bound)

        return if (random <=  attackerPoints) GOAL else NO_GOAL

    }

}