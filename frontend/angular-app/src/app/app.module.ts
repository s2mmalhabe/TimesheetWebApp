import {CUSTOM_ELEMENTS_SCHEMA, NgModule} from "@angular/core";
import {LoginComponent} from "./component/login/login.component";
import {HeaderComponent} from "./component/header/header.component";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {HTTP_INTERCEPTORS} from "@angular/common/http";
import {AuthInterceptor} from "./service/auth-interceptor";
import {CalendarComponent} from "./component/calendar/calendar.component";
import {CommonModule} from "@angular/common";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatTableModule} from "@angular/material/table";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MaterialModule} from "./material/material.module";
import {AboutUsComponent} from "./component/aboutUs/aboutUs.component";
import {ContactComponent} from "./component/contact/contact.component";
import {HomeComponent} from "./component/home/home.component";
import {PreviousProjectsComponent} from "./component/previousProjects/previousProjects.component";

@NgModule({
  declarations: [
    AboutUsComponent,
    ContactComponent,
    HomeComponent,
    LoginComponent,
    PreviousProjectsComponent,
    HeaderComponent
  ],
  exports: [HeaderComponent],
  imports: [
    MaterialModule,
    CalendarComponent,
    FormsModule,
    ReactiveFormsModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatTableModule,
    CommonModule
  ],
  providers: [{
    provide: HTTP_INTERCEPTORS,
    useClass: AuthInterceptor,
    multi: true
  }],
  schemas: [CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}
