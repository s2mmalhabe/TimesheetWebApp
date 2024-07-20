import { Routes } from '@angular/router';
import {LoginComponent} from "./component/login/login.component";
import {HomeComponent} from "./component/home/home.component";
import {AboutUsComponent} from "./component/aboutUs/aboutUs.component";
import {ContactComponent} from "./component/contact/contact.component";
import {PreviousProjectsComponent} from "./component/previousProjects/previousProjects.component";
import {TimesheetAppComponent} from "./component/timesheetApp/timesheetApp.component";
import {CalendarComponent} from "./component/calendar/calendar.component";

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'about', component: AboutUsComponent },
  { path: 'contact', component: ContactComponent },
  { path: 'login', component: LoginComponent },
  { path: 'previous-projects', component: PreviousProjectsComponent },
  { path: 'timesheet', component: TimesheetAppComponent },
  { path: 'calendar', component: CalendarComponent }
];
