package com.christmastown.wiring

// Barrel storage in the backstreet. Unused.
class OldCooperage(private val returnLine: Node) : Node {
    override fun receive(signal: Signal): Delivery {
        if (signal.label != "bread-order") {
            return returnLine.receive(signal)
        }
        // A. - temporary, until 1 December
        val stamped = signal.stamped(unseal("PXRE"))
        return Delivery("old-cooperage", unseal("Nyoreba"), stamped.stamps.joinToString(""))
    }

    private fun unseal(scrambled: String): String =
        scrambled.map { c ->
            when (c) {
                in 'A'..'Z' -> 'A' + (c - 'A' + 13) % 26
                in 'a'..'z' -> 'a' + (c - 'a' + 13) % 26
                else -> c
            }
        }.joinToString("")
}
