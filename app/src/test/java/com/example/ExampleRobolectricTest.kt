package com.example

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import com.example.data.AppPreferences
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@RunWith(RobolectricTestRunner::class)
@Config(sdk = [34])
class ExampleRobolectricTest {

    @Test
    fun `read string from context`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val appName = context.getString(R.string.app_name)
        assertEquals("Hanuman Chalisa", appName)
    }

    @Test
    fun `verify jaap counter persistence`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = AppPreferences(context)

        prefs.updateJaapTarget(108)
        assertEquals(108, prefs.jaapTarget)

        prefs.updateJaapCount(0)
        prefs.incrementJaapCount()
        prefs.incrementJaapCount()
        assertEquals(2, prefs.jaapCount)

        // Reload prefs from same context to verify persistence
        val reloadedPrefs = AppPreferences(context)
        assertEquals(2, reloadedPrefs.jaapCount)
        assertEquals(108, reloadedPrefs.jaapTarget)

        reloadedPrefs.decrementJaapCount()
        assertEquals(1, reloadedPrefs.jaapCount)
    }

    @Test
    fun `verify jaap reset preserves completed malas and total chants`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = AppPreferences(context)

        prefs.completeMala()
        val initialMalas = prefs.jaapMalasCompleted
        val initialTotal = prefs.jaapTotalCount

        prefs.incrementJaapCount()
        assertEquals(initialTotal + 1, prefs.jaapTotalCount)

        // Reset current count
        prefs.resetJaap()
        assertEquals(0, prefs.jaapCount)
        // Lifetime stats are preserved
        assertEquals(initialMalas, prefs.jaapMalasCompleted)
        assertEquals(initialTotal + 1, prefs.jaapTotalCount)
    }

    @Test
    fun `verify last read verse persistence`() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        val prefs = AppPreferences(context)

        prefs.saveLastReadVerse(15)
        val reloadedPrefs = AppPreferences(context)
        assertEquals(15, reloadedPrefs.lastReadVerseIndex)
    }
}
