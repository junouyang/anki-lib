package com.smartlearn.anki.dao

import com.smartlearn.anki.model.Card
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.sql.SQLException


class CardDao(jdbi: Jdbi): AbstractDao<Card>(jdbi) {
    override val tableName: String = "cards"
    override val rowMapper: RowMapper<Card> = CollectionMapper

    object CollectionMapper : RowMapper<Card> {
        @Throws(SQLException::class)
        override fun map(r: ResultSet, ctx: StatementContext?): Card {
            val id = r.getLong("id")
            val noteId = r.getLong("nid")
            val deckId = r.getLong("did")
            val ordinal = r.getLong("ord")
            val modifiedAt = r.getLong("mod")
            val usn = r.getLong("usn")
            val type = r.getInt("type")
            val queue = r.getInt("queue")
            val due = r.getInt("due")
            val interval = r.getLong("ivl")
            val factor = r.getInt("factor")
            val numberOfReviews = r.getLong("reps")
            val lapses = r.getLong("lapses")
            val left = r.getLong("left")
            val originalDue = r.getInt("odue")
            val originalDeckId = r.getLong("odid")
            val flags = r.getLong("flags")
            val data = r.getString("data")
            return Card(
                id = id,
                noteId = noteId,
                deckId = deckId,
                ordinal = ordinal,
                modifiedAt = modifiedAt,
                updateSequenceNumber = usn,
                type = type,
                queue = queue,
                due = due,
                interval = interval,
                factor = factor,
                numberOfReviews = numberOfReviews,
                lapses = lapses,
                left = left,
                originalDue = originalDue,
                originalDeckId = originalDeckId,
                flags = flags,
                data = data
            )
        }
    }
}