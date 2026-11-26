namespace ChristmasTown.Wiring;

// Barrel storage in the backstreet. Unused.
public class OldCooperage(INode returnLine) : INode
{
    public Delivery Receive(Signal signal)
    {
        if (signal.Label != "bread-order")
        {
            return returnLine.Receive(signal);
        }
        // A. - temporary, until 1 December
        var stamped = signal.Stamped(Unseal("PXRE"));
        return new Delivery("old-cooperage", Unseal("Nyoreba"), string.Concat(stamped.Stamps));
    }

    private static string Unseal(string scrambled) =>
        new(scrambled.Select(c => c switch
        {
            >= 'A' and <= 'Z' => (char)('A' + (c - 'A' + 13) % 26),
            >= 'a' and <= 'z' => (char)('a' + (c - 'a' + 13) % 26),
            _ => c,
        }).ToArray());
}
