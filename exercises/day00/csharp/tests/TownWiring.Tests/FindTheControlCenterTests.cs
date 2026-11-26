using ChristmasTown.Wiring;

namespace TownWiring.Tests;

// Alberon: "The wiring is old. Don't fix it, don't trust its comments.
//           Find when a signal from the pumps reaches my office, then read what my door says."
public class FindTheControlCenterTests
{
    private const string When = "??:??";

    [Fact]
    public void A_signal_sent_at_two_in_the_afternoon_lands_at_the_barn() =>
        Assert.Equal("barn", Town.Send("14:00").LandedAt);

    [Fact]
    public void A_signal_sent_When_reaches_Alberon() =>
        Assert.Equal("Alberon", Town.Send(When).SignedBy);

    [Fact]
    public void The_door_code_is() =>
        Assert.Equal("???", Town.Send(When).DoorCode);
}
