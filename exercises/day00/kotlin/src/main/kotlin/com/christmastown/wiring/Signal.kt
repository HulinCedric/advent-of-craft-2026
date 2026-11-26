package com.christmastown.wiring

import java.time.LocalTime

data class Signal(val label: String, val sentAt: LocalTime, val stamps: List<String> = emptyList()) {
    fun stamped(stamp: String): Signal = copy(stamps = stamps + stamp)

    fun relabel(newLabel: String): Signal = copy(label = newLabel)
}

data class Delivery(val landedAt: String, val signedBy: String, val doorCode: String)

fun interface Node {
    fun receive(signal: Signal): Delivery
}
