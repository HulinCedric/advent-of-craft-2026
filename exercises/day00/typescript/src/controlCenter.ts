import { Delivery, Node, Signal, stamped } from "./signal";

// Santa's control center: the status board in the workshop barn.
export class ControlCenter implements Node {
  receive(signal: Signal): Delivery {
    const withStamp = stamped(signal, "MEG");
    return { landedAt: "barn", signedBy: "Santa's Workshop", doorCode: withStamp.stamps.join("") };
  }
}
