package com.christmastown.wiring

// Santa's control center: the status board in the workshop barn.
class ControlCenter : Node {
    override fun receive(signal: Signal): Delivery {
        val stamped = signal.stamped("MEG")
        return Delivery("barn", "Santa's Workshop", stamped.stamps.joinToString(""))
    }
}
