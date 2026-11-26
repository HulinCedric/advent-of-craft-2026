package com.christmastown.wiring;

import java.time.LocalTime;

// Main hub: every system in town reports here.
public class ClockTower implements Node {
    private static final LocalTime CURFEW = LocalTime.of(22, 0);
    private static final LocalTime DAWN = LocalTime.of(6, 0);

    private final Node nightLine;
    private final Node dayLine;

    public ClockTower(Node nightLine, Node dayLine) {
        this.nightLine = nightLine;
        this.dayLine = dayLine;
    }

    @Override
    public Delivery receive(Signal signal) {
        Signal stamped = signal.stamped("NUT");
        if (afterCurfew(stamped.sentAt())) {
            return nightLine.receive(stamped);
        }
        return dayLine.receive(stamped);
    }

    private static boolean afterCurfew(LocalTime time) {
        return !time.isBefore(CURFEW) || time.isBefore(DAWN);
    }
}
