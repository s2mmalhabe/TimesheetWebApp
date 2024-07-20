import { Time } from '@angular/common';

export interface Calendar {
  date: Date;
  startTime: Time;
  endTime: Time;
  lunch: boolean;
  description: string;
}
