package com.smartlearn.anki.dao

import com.smartlearn.anki.model.Note
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.sql.SQLException


class NoteDao(jdbi: Jdbi): AbstractDao<Note>(jdbi) {
    override val tableName: String = "notes"
    override val rowMapper: RowMapper<Note> = NoteMapper

    object NoteMapper : RowMapper<Note> {
        @Throws(SQLException::class)
        override fun map(r: ResultSet, ctx: StatementContext?): Note {
            val id = r.getLong("id")
            val guid = r.getString("guid")
            val mid = r.getLong("mid")
            val mod = r.getLong("mod")
            val usn = r.getLong("usn")
            val tags = r.getString("tags")?.trim()?.split(' ')
            val fields = r.getString("flds").split('\u001f')
            val sortedField = r.getLong("sfld")
            val csum = r.getLong("csum")
            val flags = r.getLong("flags")
            val data = r.getString("data")
            return Note(
                id = id,
                guid = guid,
                mid = mid,
                modifiedAt = mod,
                usn = usn,
                tags = tags,
                fields = fields,
                sortedField = sortedField,
                csum = csum,
                flags = flags,
                data = data
            )
        }
    }
}