package com.christmastown.wiring

import java.time.LocalTime

// Main hub: every system in town reports here.
class ClockTower(private val nightLine: Node, private val dayLine: Node) : Node {

    override fun receive(signal: Signal): Delivery {
        val stamped = signal.stamped("NUT")
        if (afterCurfew(stamped.sentAt)) {
            return nightLine.receive(stamped)
        }
        return dayLine.receive(stamped)
    }

    private fun afterCurfew(time: LocalTime): Boolean = !time.isBefore(CURFEW) || time.isBefore(DAWN)

    private companion object {
        val CURFEW: LocalTime = LocalTime.of(22, 0)
        val DAWN: LocalTime = LocalTime.of(6, 0)
    }
}
