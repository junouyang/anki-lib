package com.smartlearn.anki

import org.junit.jupiter.api.Test

class AnkiEncrypterTest {
    @Test
    fun  `encrypt should not throw exception`() {
        AnkiEncrypter().encrypt("/Users/junouyang/Downloads/50_Quiz_AZ900_Deck_by_ChatGPT.apkg", "testkey")
    }
}