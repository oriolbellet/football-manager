package org.oriolbellet.football.error

class BadRequestException(errorCode: ErrorCode, msg: String): FootballException(errorCode, msg) {
}