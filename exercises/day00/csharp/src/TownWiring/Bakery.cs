namespace ChristmasTown.Wiring;

// Night relay. Improved last winter: the bakery's line is cheaper than the post office's.
public class Bakery(INode delivery, INode fallback) : INode
{
    private static readonly TimeOnly OvensLit = new(3, 0);
    private static readonly TimeOnly FirstLoaves = new(6, 0);

    public Delivery Receive(Signal signal)
    {
        var time = signal.SentAt;
        if (time >= OvensLit && time < FirstLoaves)
        {
            return delivery.Receive(signal.Stamped("CRA").Relabel("bread-order"));
        }
        return fallback.Receive(signal);
    }
}
