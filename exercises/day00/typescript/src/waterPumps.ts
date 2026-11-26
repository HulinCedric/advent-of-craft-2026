import { Delivery, Minutes, Node, reading } from "./signal";

// Water level sensors of the north pumps. They report on every reading.
export class WaterPumps {
  constructor(private readonly uplink: Node) {}

  report(at: Minutes): Delivery {
    return this.uplink.receive(reading("water-level", at));
  }
}
