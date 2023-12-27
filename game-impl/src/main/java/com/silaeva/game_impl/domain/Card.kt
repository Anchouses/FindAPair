package com.silaeva.game_impl.domain

import java.util.UUID

data class Card(
    var uuid: UUID = UUID.randomUUID(),
    val image: Int,
    var isOpen: Boolean = false
)
