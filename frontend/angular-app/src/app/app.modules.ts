import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';
import { AboutUsComponent } from './aboutUs';
import { ContactComponent } from './contact';
import { GalleryComponent } from './gallery';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { PreviousProjectsComponent } from './previousProjects';
import { TimesheetAppComponent } from './timesheetApp';

@NgModule({
  declarations: [
    AboutUsComponent,
    ContactComponent,
    GalleryComponent,
    HomeComponent,
    LoginComponent,
    PreviousProjectsComponent,
    TimesheetAppComponent
  ],
  imports: [
    AppComponent
  ]
})
export class AppModules {}
