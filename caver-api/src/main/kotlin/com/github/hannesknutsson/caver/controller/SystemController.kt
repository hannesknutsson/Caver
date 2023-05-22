package com.github.hannesknutsson.caver.controller

import com.github.hannesknutsson.caver.service.ShowService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

/**
 * TODO: This is not secured.
 * This should only be accessed by authorized admins (which do not exist yet)
 */

@RestController
@RequestMapping("/api/system")
class SystemController(
        private val showService: ShowService
) {

    @PostMapping("shows/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    fun addShow(@PathVariable id : String) {
        return showService.addShow(id);
    }

    @DeleteMapping("shows/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteShow(@PathVariable id : String) {
        return showService.deleteShow(id);
    }

}
