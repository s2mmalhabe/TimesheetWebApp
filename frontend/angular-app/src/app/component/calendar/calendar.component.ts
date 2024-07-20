import {ChangeDetectionStrategy, Component, ViewChild} from '@angular/core';
import {MatTable, MatTableModule} from '@angular/material/table';
import {FormControl, FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {provideNativeDateAdapter} from "@angular/material/core";
import * as _moment from 'moment';
import {default as _rollupMoment} from 'moment';
import {MatButton} from "@angular/material/button";
import {MatInput} from "@angular/material/input";
import {CalendarService} from "../../service/calendar.service";
import {Calendar} from "../../model/calendar";


const moment = _rollupMoment || _moment;

// See the Moment.js docs for the meaning of these formats:
// https://momentjs.com/docs/#/displaying/format/
// export const MY_FORMATS = {
//   parse: {
//     dateInput: 'LL',
//   },
//   display: {
//     dateInput: 'LL',
//     monthYearLabel: 'MMM YYYY',
//     dateA11yLabel: 'LL',
//     monthYearA11yLabel: 'MMMM YYYY',
//   },
// };

export interface PeriodicElement {
  name: string;
  position: number;
  weight: number;
  symbol: string;
}
const today = new Date();
const month = today.getMonth();
const year = today.getFullYear();

const ELEMENT_DATA: PeriodicElement[] = [
  {position: 1, name: '', weight: 0, symbol: ''},
];

/**
 * @title Styling columns using their auto-generated column names
 */
@Component({
  selector: 'calendar',
  styleUrl: 'calendar.component.css',
  templateUrl: 'calendar.component.html',
  standalone: true,
  imports: [MatTableModule, MatFormFieldModule, MatDatepickerModule, FormsModule, ReactiveFormsModule, MatButton, MatInput],
  providers: [provideNativeDateAdapter()],
  changeDetection: ChangeDetectionStrategy.OnPush,

})
export class CalendarComponent {
  constructor(private calendarService: CalendarService) {}

  displayedColumns: string[] = ['name', 'object', 'starttime', 'lunch', 'endtime', 'description'];
  dataSource = ELEMENT_DATA;
  calendarToSave!: Calendar;
  private readonly _currentYear = new Date().getFullYear();
  readonly minDate = new Date(this._currentYear - 20, 0, 1);
  readonly maxDate = new Date(this._currentYear + 1, 11, 31);


  // @ts-ignore
  // @ViewChild(MatTable) table: MatTable<PeriodicElement>;
  // addData() {
  //   const randomElementIndex = ELEMENT_DATA.length - 1;
  //   this.dataSource.push(ELEMENT_DATA[randomElementIndex]);
  //   this.table.renderRows();
  // }
  //
  // removeData() {
  //   this.dataSource.pop();
  //   this.table.renderRows();
  // }
  // readonly date = new FormControl(moment());

  save() {
    this.calendarService.saveCalendar(this.calendarToSave)
    .subscribe();

  }
}
