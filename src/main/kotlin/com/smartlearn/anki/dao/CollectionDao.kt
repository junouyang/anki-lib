package com.smartlearn.anki.dao

import com.smartlearn.anki.model.Collection
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.core.mapper.RowMapper
import org.jdbi.v3.core.statement.StatementContext
import java.sql.ResultSet
import java.sql.SQLException


class CollectionDao(jdbi: Jdbi): AbstractDao<Collection>(jdbi) {
    override val tableName: String = "col"
    override val rowMapper: RowMapper<Collection> = CardMapper

    object CardMapper : RowMapper<Collection> {
        @Throws(SQLException::class)
        override fun map(r: ResultSet, ctx: StatementContext?): Collection {
            val id = r.getLong("id")
            val createdAt = r.getLong("crt")
            val modifiedAt = r.getLong("mod")
            val schemaModifiedAt = r.getLong("scm")
            val version = r.getLong("ver")
            val dirty = r.getInt("dty")
            val updateSequenceNumber = r.getLong("usn")
            val lastSyncTime = r.getLong("ls")
            val config = r.getString("conf")
            val models = r.getString("models")
            val decks = r.getString("decks")
            val deckConfigs = r.getString("dconf")

            val tags = r.getString("tags")?.trim()?.split(' ')
            return Collection(
                id = id,
                modifiedAt = modifiedAt,
                updateSequenceNumber = updateSequenceNumber,
                tags = tags,
                createdAt = createdAt,
                schemaModifiedAt = schemaModifiedAt,
                version = version,
                dirty = dirty,
                lastSyncTime = lastSyncTime,
                config = config,
                models = models,
                decks = decks,
                deckConfigs = deckConfigs,
            )
        }
    }
}