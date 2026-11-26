import { Delivery, Node, Signal } from "./signal";

// Keeps what nobody claimed for the morning round.
export class PostOffice implements Node {
  constructor(private readonly morningRound: Node) {}

  receive(signal: Signal): Delivery {
    return this.morningRound.receive(signal);
  }
}
