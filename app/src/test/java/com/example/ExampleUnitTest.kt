package com.example

import com.example.data.ChalisaData
import com.example.model.VerseType
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {
    @Test
    fun testChalisaVersesCount() {
        assertEquals("Total verses should be 43 (2 opening Dohas, 40 Chaupais, 1 closing Doha)", 43, ChalisaData.verses.size)
    }

    @Test
    fun testFirstAndLastVerse() {
        val openingDoha1 = ChalisaData.getVerse(0)
        assertEquals(VerseType.DOHA, openingDoha1.type)
        assertTrue(openingDoha1.hindiText.contains("श्रीगुरु चरन सरोज रज"))

        val chaupai1 = ChalisaData.getVerse(2)
        assertEquals(VerseType.CHAUPAI, chaupai1.type)
        assertTrue(chaupai1.hindiText.contains("जय हनुमान ज्ञान गुन सागर"))

        val closingDoha = ChalisaData.getVerse(42)
        assertEquals(VerseType.DOHA, closingDoha.type)
        assertTrue(closingDoha.hindiText.contains("पवन तनय संकट हरन"))
    }

    @Test
    fun testVersesCompleteness() {
        ChalisaData.verses.forEach { verse ->
            assertNotNull(verse.hindiText)
            assertTrue("Hindi text should not be empty for verse ${verse.id}", verse.hindiText.isNotBlank())
            assertTrue("Transliteration should not be empty for verse ${verse.id}", verse.englishTranslit.isNotBlank())
            assertTrue("Hindi meaning should not be empty for verse ${verse.id}", verse.hindiMeaning.isNotBlank())
            assertTrue("English meaning should not be empty for verse ${verse.id}", verse.englishMeaning.isNotBlank())
        }
    }
}
