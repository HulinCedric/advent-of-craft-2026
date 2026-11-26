package com.christmastown.wiring;

import java.time.LocalTime;

// Night relay. Improved last winter: the bakery's line is cheaper than the post office's.
public class Bakery implements Node {
    private static final LocalTime OVENS_LIT = LocalTime.of(3, 0);
    private static final LocalTime FIRST_LOAVES = LocalTime.of(6, 0);

    private final Node delivery;
    private final Node fallback;

    public Bakery(Node delivery, Node fallback) {
        this.delivery = delivery;
        this.fallback = fallback;
    }

    @Override
    public Delivery receive(Signal signal) {
        LocalTime time = signal.sentAt();
        if (!time.isBefore(OVENS_LIT) && time.isBefore(FIRST_LOAVES)) {
            return delivery.receive(signal.stamped("CRA").relabel("bread-order"));
        }
        return fallback.receive(signal);
    }
}
