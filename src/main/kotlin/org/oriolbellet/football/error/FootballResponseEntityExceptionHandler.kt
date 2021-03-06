package org.oriolbellet.football.error

import org.oriolbellet.football.error.ErrorCode.UNKNOWN
import org.springframework.http.HttpHeaders
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import org.springframework.http.converter.HttpMessageNotReadableException

import org.springframework.http.HttpStatus
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class FootballResponseEntityExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException, request: WebRequest): ResponseEntity<Any> {

        val errorDto = ErrorDto(ex.errorCode, ex.message ?: "")

        return handleExceptionInternal(ex, errorDto, HttpHeaders(), NOT_FOUND, request)

    }

    @ExceptionHandler(MatchException::class)
    fun handleNotFound(ex: MatchException, request: WebRequest): ResponseEntity<Any> {

        val errorDto = ErrorDto(ex.errorCode, ex.message ?: "")

        return handleExceptionInternal(ex, errorDto, HttpHeaders(), CONFLICT, request)

    }

    @ExceptionHandler(Exception::class)
    protected fun handleEx(ex: Exception, request: WebRequest): ResponseEntity<Any> {
        val errorDto = ErrorDto(UNKNOWN, ex.message ?: "")
        return handleExceptionInternal(ex, errorDto, HttpHeaders(), INTERNAL_SERVER_ERROR, request)
    }
}