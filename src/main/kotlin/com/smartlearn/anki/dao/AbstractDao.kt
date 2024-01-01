package com.smartlearn.anki.dao

import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.sqlite3.SQLitePlugin


abstract class AbstractDao<T>(private val jdbi: Jdbi) {
    protected abstract val tableName: String
    protected abstract val rowMapper: RowMapper<T>

    fun list(): List<T> {
        val handle = jdbi.open()
        val notes = handle.createQuery("select * from $tableName").map(rowMapper)
        val result = notes.collectIntoList()
        handle.close()
        return result
    }
}