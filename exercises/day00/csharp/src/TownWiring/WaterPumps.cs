namespace ChristmasTown.Wiring;

// Water level sensors of the north pumps. They report on every reading.
public class WaterPumps(INode uplink)
{
    public Delivery Report(TimeOnly at) => uplink.Receive(Signal.Reading("water-level", at));
}
