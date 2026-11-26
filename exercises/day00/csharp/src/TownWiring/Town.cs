using System.Globalization;

namespace ChristmasTown.Wiring;

public static class Town
{
    private static readonly WaterPumps Pumps = Wire();

    // Sends a water level reading from the pumps at the given time ("HH:mm") and tells where it ended up.
    public static Delivery Send(string time) => Pumps.Report(Parse(time));

    private static WaterPumps Wire()
    {
        var barn = new ControlCenter();
        var postOffice = new PostOffice(barn);
        var cooperage = new OldCooperage(barn);
        var bakery = new Bakery(cooperage, postOffice);
        var clockTower = new ClockTower(bakery, barn);
        return new WaterPumps(clockTower);
    }

    private static TimeOnly Parse(string time) =>
        TimeOnly.TryParseExact(time, "HH:mm", CultureInfo.InvariantCulture, DateTimeStyles.None, out var parsed)
            ? parsed
            : throw new ArgumentException($"A signal needs a time like 14:00, got \"{time}\"");
}
