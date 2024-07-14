import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app.routes';
import { AppComponent } from './app.component';
//import { provideHttpClient } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AboutUsComponent } from './aboutUs';
import { ContactComponent } from './contact';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { PreviousProjectsComponent } from './previousProjects';
import { TimesheetAppComponent } from './timesheetApp';

@NgModule({
  declarations: [
    AboutUsComponent,
    ContactComponent,
    HomeComponent,
    LoginComponent,
    PreviousProjectsComponent,
    TimesheetAppComponent
  ],
  imports: [
    AppComponent,
    BrowserModule,
    AppRoutingModule,
    //provideHttpClient,
    FormsModule

  ],
})
export class AppModules {}
