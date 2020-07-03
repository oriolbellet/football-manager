package org.oriolbellet.football.error

class NotFoundException(errorCode: ErrorCode, msg: String): FootballException(errorCode, msg) {
}