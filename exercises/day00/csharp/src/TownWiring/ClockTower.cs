namespace ChristmasTown.Wiring;

// Main hub: every system in town reports here.
public class ClockTower(INode nightLine, INode dayLine) : INode
{
    private static readonly TimeOnly Curfew = new(22, 0);
    private static readonly TimeOnly Dawn = new(6, 0);

    public Delivery Receive(Signal signal)
    {
        var stamped = signal.Stamped("NUT");
        if (AfterCurfew(stamped.SentAt))
        {
            return nightLine.Receive(stamped);
        }
        return dayLine.Receive(stamped);
    }

    private static bool AfterCurfew(TimeOnly time) => time >= Curfew || time < Dawn;
}
