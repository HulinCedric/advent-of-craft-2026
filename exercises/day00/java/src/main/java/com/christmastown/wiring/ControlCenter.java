package com.christmastown.wiring;

// Santa's control center: the status board in the workshop barn.
public class ControlCenter implements Node {

    @Override
    public Delivery receive(Signal signal) {
        Signal stamped = signal.stamped("MEG");
        return new Delivery("barn", "Santa's Workshop", String.join("", stamped.stamps()));
    }
}
