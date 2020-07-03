package org.oriolbellet.football.error

class MatchException(errorCode: ErrorCode, msg: String): FootballException(errorCode, msg) {
}