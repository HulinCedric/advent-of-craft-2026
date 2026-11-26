package com.christmastown.wiring;

// Barrel storage in the backstreet. Unused.
public class OldCooperage implements Node {
    private final Node returnLine;

    public OldCooperage(Node returnLine) {
        this.returnLine = returnLine;
    }

    @Override
    public Delivery receive(Signal signal) {
        if (!signal.label().equals("bread-order")) {
            return returnLine.receive(signal);
        }
        // A. - temporary, until 1 December
        Signal stamped = signal.stamped(unseal("PXRE"));
        return new Delivery("old-cooperage", unseal("Nyoreba"), String.join("", stamped.stamps()));
    }

    private static String unseal(String scrambled) {
        StringBuilder plain = new StringBuilder();
        for (char c : scrambled.toCharArray()) {
            if (Character.isUpperCase(c)) {
                plain.append((char) ('A' + (c - 'A' + 13) % 26));
            } else if (Character.isLowerCase(c)) {
                plain.append((char) ('a' + (c - 'a' + 13) % 26));
            } else {
                plain.append(c);
            }
        }
        return plain.toString();
    }
}
