import { at, Delivery, Node, relabel, Signal, stamped } from "./signal";

const OVENS_LIT = at(3, 0);
const FIRST_LOAVES = at(6, 0);

// Night relay. Improved last winter: the bakery's line is cheaper than the post office's.
export class Bakery implements Node {
  constructor(
    private readonly delivery: Node,
    private readonly fallback: Node,
  ) {}

  receive(signal: Signal): Delivery {
    const time = signal.sentAt;
    if (time >= OVENS_LIT && time < FIRST_LOAVES) {
      return this.delivery.receive(relabel(stamped(signal, "CRA"), "bread-order"));
    }
    return this.fallback.receive(signal);
  }
}
