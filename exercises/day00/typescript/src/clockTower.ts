import { at, Delivery, Minutes, Node, Signal, stamped } from "./signal";

const CURFEW = at(22, 0);
const DAWN = at(6, 0);

const afterCurfew = (time: Minutes): boolean => time >= CURFEW || time < DAWN;

// Main hub: every system in town reports here.
export class ClockTower implements Node {
  constructor(
    private readonly nightLine: Node,
    private readonly dayLine: Node,
  ) {}

  receive(signal: Signal): Delivery {
    const withStamp = stamped(signal, "NUT");
    if (afterCurfew(withStamp.sentAt)) {
      return this.nightLine.receive(withStamp);
    }
    return this.dayLine.receive(withStamp);
  }
}
