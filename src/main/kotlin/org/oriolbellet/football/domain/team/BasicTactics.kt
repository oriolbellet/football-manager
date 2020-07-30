package org.oriolbellet.football.domain.team

enum class BasicTactics : Tactic {

    T343 {
        override fun getNumDefenders(): Int {
            return 3
        }

        override fun getNumMidfielders(): Int {
            return 4
        }

        override fun getNumForwards(): Int {
            return 3
        }
    },
    T442 {
        override fun getNumDefenders(): Int {
            return 4
        }

        override fun getNumMidfielders(): Int {
            return 4
        }

        override fun getNumForwards(): Int {
            return 2
        }
    },

}