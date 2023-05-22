package com.github.hannesknutsson.caver.configuration

import com.github.hannesknutsson.caver.model.exception.ShowException
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.context.request.WebRequest
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler


@ControllerAdvice
class RestExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(value = [ShowException::class])
    protected fun handleShowException(ex: RuntimeException?, request: WebRequest?): ResponseEntity<Any?>? {
        return handleExceptionInternal(ex!!, ex.message, HttpHeaders(), HttpStatus.BAD_REQUEST, request!!)
    }

    @ExceptionHandler(value = [Exception::class])
    protected fun handleAll(ex: Exception?, request: WebRequest?): ResponseEntity<Any?>? {
        return handleExceptionInternal(ex!!, "Unknown Error", HttpHeaders(), HttpStatus.INTERNAL_SERVER_ERROR, request!!)
    }

}