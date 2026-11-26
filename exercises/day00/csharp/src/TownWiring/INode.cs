namespace ChristmasTown.Wiring;

public interface INode
{
    Delivery Receive(Signal signal);
}
