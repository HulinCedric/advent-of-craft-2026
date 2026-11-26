import { describe, expect, test } from "vitest";
import { send } from "../src/town";

// Alberon: "The wiring is old. Don't fix it, don't trust its comments.
//           Find when a signal from the pumps reaches my office, then read what my door says."
const WHEN = "??:??";

describe("find the control center", () => {
  test("a signal sent at two in the afternoon lands at the barn", () => {
    expect(send("14:00").landedAt).toBe("barn");
  });

  test("a signal sent WHEN reaches Alberon", () => {
    expect(send(WHEN).signedBy).toBe("Alberon");
  });

  test("the door code is", () => {
    expect(send(WHEN).doorCode).toBe("???");
  });
});
