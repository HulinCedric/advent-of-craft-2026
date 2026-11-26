package com.christmastown.wiring

// Keeps what nobody claimed for the morning round.
class PostOffice(private val morningRound: Node) : Node {
    override fun receive(signal: Signal): Delivery = morningRound.receive(signal)
}
