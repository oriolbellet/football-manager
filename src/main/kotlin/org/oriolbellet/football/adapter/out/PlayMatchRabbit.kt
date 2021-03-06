package org.oriolbellet.football.adapter.out

import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.oriolbellet.football.application.port.out.PlayMatch
import org.oriolbellet.football.domain.match.Match
import org.springframework.amqp.AmqpException
import org.springframework.amqp.rabbit.core.RabbitTemplate
import javax.inject.Named

@Named
class PlayMatchRabbit(private val rabbitTemplate: RabbitTemplate): PlayMatch {

    override fun invoke(match: Match) {
        try {
            rabbitTemplate.convertAndSend("football-exchange", "com.oriolbellet.football.play-match", parse(match))
        } catch (e: AmqpException) {
            println(e.localizedMessage)
        }
    }

    private fun parse(match: Match): String {

        val homeTeamPlayers = match.homeTeam.lineUp.lineUp.map { x -> PlayerDto(x.playerId!!.toString(), x.alias, x.average) }.toList()
        val homeTeamLineUp = LineUpDto(homeTeamPlayers, match.homeTeam.lineUp.tactic.name)
        val homeTeam = TeamDto(match.homeTeam.name, homeTeamLineUp)

        val awayTeamPlayers = match.awayTeam.lineUp.lineUp.map { x -> PlayerDto(x.playerId!!.toString(), x.alias, x.average) }.toList()
        val awayTeamLineUp = LineUpDto(awayTeamPlayers, match.awayTeam.lineUp.tactic.name)
        val awayTeam = TeamDto(match.awayTeam.name, awayTeamLineUp)

        return Json.encodeToString(MatchDto(match.matchId!!, homeTeam, awayTeam))

    }

}