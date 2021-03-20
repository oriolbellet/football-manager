package org.oriolbellet.football.adapter.out.persistence.game

import org.oriolbellet.football.adapter.out.persistence.team.TeamDataEntity
import java.util.*
import javax.persistence.*

@Entity
@Table(name = "SEASON")
data class SeasonDataEntity(

    @Id
    @Column(name = "SEASON_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    val seasonId: UUID?,

    @Column(name = "CURRENT_WEEK")
    val currentWeek: Int,

    @OneToMany(cascade = [CascadeType.ALL])
    val gameWeeks: List<GameWeekDataEntity>,

    @OneToMany(cascade = [CascadeType.ALL])
    val teams: List<TeamDataEntity>)