package com.christmastown.wiring;

// Keeps what nobody claimed for the morning round.
public class PostOffice implements Node {
    private final Node morningRound;

    public PostOffice(Node morningRound) {
        this.morningRound = morningRound;
    }

    @Override
    public Delivery receive(Signal signal) {
        return morningRound.receive(signal);
    }
}
