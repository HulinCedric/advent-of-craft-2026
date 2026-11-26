package com.christmastown.wiring

import java.time.LocalTime

// Night relay. Improved last winter: the bakery's line is cheaper than the post office's.
class Bakery(private val delivery: Node, private val fallback: Node) : Node {

    override fun receive(signal: Signal): Delivery {
        val time = signal.sentAt
        if (!time.isBefore(OVENS_LIT) && time.isBefore(FIRST_LOAVES)) {
            return delivery.receive(signal.stamped("CRA").relabel("bread-order"))
        }
        return fallback.receive(signal)
    }

    private companion object {
        val OVENS_LIT: LocalTime = LocalTime.of(3, 0)
        val FIRST_LOAVES: LocalTime = LocalTime.of(6, 0)
    }
}
