package com.smartlearn.anki.model

data class Note(
    var id: Long = 0,
    var guid: String? = null,
    var mid: Long = 0,
    var tags: List<String>? = null,
    var fields: List<String> = emptyList(),
    var flags: Long = 0,
    var data: String? = null,
    var scm: Long = 0,
    var usn: Long = 0,
    var modifiedAt: Long = 0,
    var sortedField: Long? = null,
    var csum: Long = 0
)