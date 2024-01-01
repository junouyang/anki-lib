package com.smartlearn.anki.model

data class Card(
    var id: Long = 0,
    var noteId: Long = 0,
    var deckId: Long = 0,
    var flags: Long = 0,
    var data: String? = null,
    var updateSequenceNumber: Long = 0,
    var modifiedAt: Long = 0,
    var ordinal: Long = 0,
    var type: Int = 0,
    var queue: Int = 0,
    var due: Int = 0,
    val interval: Long = 0,
    var factor: Int = 0,
    var numberOfReviews: Long = 0,
    var lapses: Long = 0,
    var left: Long = 0,
    var originalDue: Int = 0,
    var originalDeckId: Long = 0,
)