package org.oriolbellet.football.adapter.`in`.match.listeners

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import org.oriolbellet.football.application.port.`in`.PlayedMatchUseCase
import org.oriolbellet.football.domain.match.Score
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.amqp.rabbit.annotation.RabbitListener
import javax.inject.Named

@Named
class MatchPlayedListener(private val playedMatchUseCase: PlayedMatchUseCase) {

    private val logger: Logger = LoggerFactory.getLogger(this.javaClass.simpleName)

    @RabbitListener(queues = ["match-played"])
    fun matchPlayed(message: String) {

        try {

            val matchScore = Json.decodeFromString<MatchScoreDto>(message)
            val score = Score(matchScore.score.homeTeamGoals, matchScore.score.awayTeamGoals)

            playedMatchUseCase(matchScore.matchId, score)

        } catch (e: Exception) {
            logger.error("Error updating the played match", e)
        }

    }

}