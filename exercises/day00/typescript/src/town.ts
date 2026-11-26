import { Bakery } from "./bakery";
import { ClockTower } from "./clockTower";
import { ControlCenter } from "./controlCenter";
import { OldCooperage } from "./oldCooperage";
import { PostOffice } from "./postOffice";
import { at, Delivery, Minutes } from "./signal";
import { WaterPumps } from "./waterPumps";

const wire = (): WaterPumps => {
  const barn = new ControlCenter();
  const postOffice = new PostOffice(barn);
  const cooperage = new OldCooperage(barn);
  const bakery = new Bakery(cooperage, postOffice);
  const clockTower = new ClockTower(bakery, barn);
  return new WaterPumps(clockTower);
};

const pumps = wire();

const parse = (time: string): Minutes => {
  const match = /^([01]\d|2[0-3]):([0-5]\d)$/.exec(time);
  if (!match) {
    throw new Error(`A signal needs a time like 14:00, got "${time}"`);
  }
  return at(Number(match[1]), Number(match[2]));
};

// Sends a water level reading from the pumps at the given time ("HH:mm") and tells where it ended up.
export const send = (time: string): Delivery => pumps.report(parse(time));
