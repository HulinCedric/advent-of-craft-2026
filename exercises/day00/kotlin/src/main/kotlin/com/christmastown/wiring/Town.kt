package com.christmastown.wiring

import java.time.LocalTime
import java.time.format.DateTimeParseException

object Town {
    private val pumps: WaterPumps = wire()

    // Sends a water level reading from the pumps at the given time ("HH:mm") and tells where it ended up.
    fun send(time: String): Delivery = pumps.report(parse(time))

    private fun wire(): WaterPumps {
        val barn = ControlCenter()
        val postOffice = PostOffice(barn)
        val cooperage = OldCooperage(barn)
        val bakery = Bakery(cooperage, postOffice)
        val clockTower = ClockTower(bakery, barn)
        return WaterPumps(clockTower)
    }

    private fun parse(time: String): LocalTime =
        try {
            LocalTime.parse(time)
        } catch (e: DateTimeParseException) {
            throw IllegalArgumentException("A signal needs a time like 14:00, got \"$time\"")
        }
}
