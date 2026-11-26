package com.christmastown.wiring

import kotlin.test.Test
import kotlin.test.assertEquals

// Alberon: "The wiring is old. Don't fix it, don't trust its comments.
//           Find when a signal from the pumps reaches my office, then read what my door says."
private const val WHEN = "??:??"

class FindTheControlCenterTest {

    @Test
    fun `a signal sent at two in the afternoon lands at the barn`() {
        assertEquals("barn", Town.send("14:00").landedAt)
    }

    @Test
    fun `a signal sent WHEN reaches Alberon`() {
        assertEquals("Alberon", Town.send(WHEN).signedBy)
    }

    @Test
    fun `the door code is`() {
        assertEquals("???", Town.send(WHEN).doorCode)
    }
}
