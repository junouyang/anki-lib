package com.smartlearn.anki

import com.smartlearn.anki.dao.CardDao
import com.smartlearn.anki.dao.CollectionDao
import com.smartlearn.anki.dao.NoteDao
import org.apache.commons.compress.archivers.zip.ZipFile
import org.apache.commons.compress.utils.IOUtils
import org.jdbi.v3.core.Jdbi
import org.jdbi.v3.sqlite3.SQLitePlugin
import java.io.FileOutputStream
import java.io.InputStream
import java.io.OutputStream
import java.util.UUID


class AnkiEncrypter {
    companion object {
        const val ANKI2_COLLECTION = "collection.anki21"
    }

    fun encrypt(file: String, key: String) {
        val dbFile = extractEntry(file, ANKI2_COLLECTION)
        val jdbi = Jdbi.create("jdbc:sqlite:$dbFile")
            .installPlugin(SQLitePlugin())
        val cardDao = CardDao(jdbi)
        val noteDao = NoteDao(jdbi)
        val collectionDao = CollectionDao(jdbi)

        println("Cards ======================")
        cardDao.list().forEach { println(it) }

        println("\n\nNotes ======================")
        noteDao.list().forEach { println(it) }

        println("\n\nCollections ======================")
        collectionDao.list().forEach { println(it) }
    }

    private fun extractEntry(file: String, entry: String): String {
        val tempFile = "/tmp/" + UUID.randomUUID().toString()
        val zipFile = ZipFile(file)
        val entry = zipFile.getEntry(entry)
        var content: InputStream? = null
        var outputStream: OutputStream? = null
        try {
            content = zipFile.getInputStream(entry)
            outputStream = FileOutputStream(tempFile)
            IOUtils.copy(content, outputStream)
        } finally {
            content?.close()
            outputStream?.close()
        }
        return tempFile
    }
}