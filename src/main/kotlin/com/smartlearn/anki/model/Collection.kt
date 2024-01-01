package com.smartlearn.anki.model

data class Collection(
    var id: Long = 0,
    var createdAt: Long = 0,
    var scm: Long = 0,
    var modifiedAt: Long = 0,
    var version: Long = 0,
    var dirty: Int = 0,
    var updateSequenceNumber: Long = 0,
    var lastSyncTime: Long = 0,
    var config: String? = null,
    var models: String? = null,
    var decks: String? = null,
    var deckConfigs: String? = null,
    var tags: List<String>? = null,
    var schemaModifiedAt: Long = 0,
)