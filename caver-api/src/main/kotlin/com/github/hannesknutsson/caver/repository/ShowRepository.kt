package com.github.hannesknutsson.caver.repository

import com.github.hannesknutsson.caver.model.show.Show
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ShowRepository : CrudRepository<Show, String>