package com.christmastown.wiring;

import java.time.LocalTime;

// Water level sensors of the north pumps. They report on every reading.
public class WaterPumps {
    private final Node uplink;

    public WaterPumps(Node uplink) {
        this.uplink = uplink;
    }

    public Delivery report(LocalTime at) {
        return uplink.receive(Signal.reading("water-level", at));
    }
}
