namespace ChristmasTown.Wiring;

// Santa's control center: the status board in the workshop barn.
public class ControlCenter : INode
{
    public Delivery Receive(Signal signal)
    {
        var stamped = signal.Stamped("MEG");
        return new Delivery("barn", "Santa's Workshop", string.Concat(stamped.Stamps));
    }
}
