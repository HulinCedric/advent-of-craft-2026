package com.christmastown.wiring;

public interface Node {
    Delivery receive(Signal signal);
}
