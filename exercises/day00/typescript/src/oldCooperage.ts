import { Delivery, Node, Signal, stamped } from "./signal";

const unseal = (scrambled: string): string =>
  scrambled.replace(/[a-z]/gi, (c) => {
    const base = c <= "Z" ? 65 : 97;
    return String.fromCharCode(base + ((c.charCodeAt(0) - base + 13) % 26));
  });

// Barrel storage in the backstreet. Unused.
export class OldCooperage implements Node {
  constructor(private readonly returnLine: Node) {}

  receive(signal: Signal): Delivery {
    if (signal.label !== "bread-order") {
      return this.returnLine.receive(signal);
    }
    // A. - temporary, until 1 December
    const withStamp = stamped(signal, unseal("PXRE"));
    return { landedAt: "old-cooperage", signedBy: unseal("Nyoreba"), doorCode: withStamp.stamps.join("") };
  }
}
