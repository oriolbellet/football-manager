package org.oriolbellet.football.domain.team

interface Tactic {

    fun getNumDefenders(): Int

    fun getNumMidfielders(): Int

    fun getNumForwards(): Int

}