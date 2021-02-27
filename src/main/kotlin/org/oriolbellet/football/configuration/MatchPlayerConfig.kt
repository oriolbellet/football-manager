package org.oriolbellet.football.configuration

import org.oriolbellet.football.domain.match.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import javax.inject.Inject

@Configuration
class MatchPlayerConfig(
    private val possessionCalculator: PossessionCalculator,
    private val attackSimulator: AttackSimulator
) {

    @Bean
    fun matchPlayer(): MatchAlgorithm {
        return BasicMatchAlgorithm(this.possessionCalculator, this.attackSimulator)
    }

}