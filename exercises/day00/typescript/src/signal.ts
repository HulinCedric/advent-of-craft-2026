// A time of day, in minutes after midnight.
export type Minutes = number;

export const at = (hours: number, minutes: number): Minutes => hours * 60 + minutes;

export type Signal = {
  readonly label: string;
  readonly sentAt: Minutes;
  readonly stamps: readonly string[];
};

export const reading = (label: string, sentAt: Minutes): Signal => ({ label, sentAt, stamps: [] });

export const stamped = (signal: Signal, stamp: string): Signal => ({ ...signal, stamps: [...signal.stamps, stamp] });

export const relabel = (signal: Signal, label: string): Signal => ({ ...signal, label });

export type Delivery = {
  readonly landedAt: string;
  readonly signedBy: string;
  readonly doorCode: string;
};

export interface Node {
  receive(signal: Signal): Delivery;
}
