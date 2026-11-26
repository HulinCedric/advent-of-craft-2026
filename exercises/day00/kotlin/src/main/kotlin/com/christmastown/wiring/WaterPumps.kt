package com.christmastown.wiring

import java.time.LocalTime

// Water level sensors of the north pumps. They report on every reading.
class WaterPumps(private val uplink: Node) {
    fun report(at: LocalTime): Delivery = uplink.receive(Signal("water-level", at))
}
