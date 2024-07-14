import {RouterModule, Routes} from '@angular/router';
import {NgModule} from "@angular/core";


import {HomeComponent} from "./home";
import {AboutUsComponent} from "./aboutUs";
import {ContactComponent} from "./contact";
import {LoginComponent} from "./login";
import {PreviousProjectsComponent} from "./previousProjects";
import {TimesheetAppComponent} from "./timesheetApp";
//import {CalendarComponent} from "./calendar/calendar.component";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'about', component: AboutUsComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'login', component: LoginComponent},
  {path: 'previous projects', component: PreviousProjectsComponent},
  {path: 'timesheet', component: TimesheetAppComponent},
  //{path: 'calendar', component: CalendarComponent},
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
