namespace ChristmasTown.Wiring;

public sealed record Signal(string Label, TimeOnly SentAt, IReadOnlyList<string> Stamps)
{
    public static Signal Reading(string label, TimeOnly sentAt) => new(label, sentAt, []);

    public Signal Stamped(string stamp) => this with { Stamps = [.. Stamps, stamp] };

    public Signal Relabel(string newLabel) => this with { Label = newLabel };
}
