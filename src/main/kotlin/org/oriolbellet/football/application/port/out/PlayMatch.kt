package org.oriolbellet.football.application.port.out

import org.oriolbellet.football.domain.match.Match

@FunctionalInterface
interface PlayMatch {

    operator fun invoke(match: Match)

}