package com.christmastown.wiring;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public record Signal(String label, LocalTime sentAt, List<String> stamps) {

    public static Signal reading(String label, LocalTime sentAt) {
        return new Signal(label, sentAt, List.of());
    }

    public Signal stamped(String stamp) {
        List<String> all = new ArrayList<>(stamps);
        all.add(stamp);
        return new Signal(label, sentAt, List.copyOf(all));
    }

    public Signal relabel(String newLabel) {
        return new Signal(newLabel, sentAt, stamps);
    }
}
