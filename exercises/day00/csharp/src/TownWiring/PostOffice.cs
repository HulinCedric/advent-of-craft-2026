namespace ChristmasTown.Wiring;

// Keeps what nobody claimed for the morning round.
public class PostOffice(INode morningRound) : INode
{
    public Delivery Receive(Signal signal) => morningRound.Receive(signal);
}
