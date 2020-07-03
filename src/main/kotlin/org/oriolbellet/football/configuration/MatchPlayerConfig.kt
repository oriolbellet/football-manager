package org.oriolbellet.football.configuration

import org.oriolbellet.football.domain.match.MatchPlayer
import org.oriolbellet.football.domain.match.RandomMatchPlayer
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class MatchPlayerConfig {

    @Bean
    fun matchPlayer(): MatchPlayer {
        return RandomMatchPlayer()
    }

}