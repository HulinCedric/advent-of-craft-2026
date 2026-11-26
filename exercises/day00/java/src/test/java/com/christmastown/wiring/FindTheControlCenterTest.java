package com.christmastown.wiring;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Alberon: "The wiring is old. Don't fix it, don't trust its comments.
//           Find when a signal from the pumps reaches my office, then read what my door says."
class FindTheControlCenterTest {

    private static final String WHEN = "??:??";

    @Test
    void a_signal_sent_at_two_in_the_afternoon_lands_at_the_barn() {
        assertEquals("barn", Town.send("14:00").landedAt());
    }

    @Test
    void a_signal_sent_WHEN_reaches_alberon() {
        assertEquals("Alberon", Town.send(WHEN).signedBy());
    }

    @Test
    void the_door_code_is() {
        assertEquals("???", Town.send(WHEN).doorCode());
    }
}
