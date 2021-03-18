package org.oriolbellet.football.adapter.out.persistence.match

import org.oriolbellet.football.adapter.out.persistence.team.TeamDataEntity
import org.oriolbellet.football.domain.match.Score
import javax.persistence.*

@Entity
@Table(name = "MATCH")
data class MatchDataEntity(

    @Id
    @Column(name = "MATCH_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val matchId: Long?,

    @ManyToOne
    @JoinColumn(name = "HOME_TEAM_ID", nullable = false)
    val homeTeam: TeamDataEntity,

    @ManyToOne
    @JoinColumn(name = "AWAY_TEAM_ID", nullable = false)
    val awayTeam: TeamDataEntity,

    @Embedded
    val score: Score?)