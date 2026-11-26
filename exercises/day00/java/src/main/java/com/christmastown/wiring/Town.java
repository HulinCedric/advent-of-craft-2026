package com.christmastown.wiring;

import java.time.LocalTime;
import java.time.format.DateTimeParseException;

public final class Town {
    private static final WaterPumps PUMPS = wire();

    private Town() {
    }

    // Sends a water level reading from the pumps at the given time ("HH:mm") and tells where it ended up.
    public static Delivery send(String time) {
        return PUMPS.report(parse(time));
    }

    private static WaterPumps wire() {
        ControlCenter barn = new ControlCenter();
        PostOffice postOffice = new PostOffice(barn);
        OldCooperage cooperage = new OldCooperage(barn);
        Bakery bakery = new Bakery(cooperage, postOffice);
        ClockTower clockTower = new ClockTower(bakery, barn);
        return new WaterPumps(clockTower);
    }

    private static LocalTime parse(String time) {
        try {
            return LocalTime.parse(time);
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("A signal needs a time like 14:00, got \"" + time + "\"");
        }
    }
}
