package com.silaeva.game_impl.domain

import java.util.UUID

data class Card(
    val uuid: UUID = UUID.randomUUID(),
    val image: Int,
    var isOpen: Boolean = false
)
