import { Routes } from '@angular/router';
import {HomeComponent} from "./home";
import {AboutUsComponent} from "./aboutUs";
import {ContactComponent} from "./contact";
import {GalleryComponent} from "./gallery";
import {LoginComponent} from "./login";
import {PreviousProjectsComponent} from "./previousProjects";

export const routes: Routes = [
  {path: '', component: HomeComponent},
  {path: 'about-us', component: AboutUsComponent},
  {path: 'contact', component: ContactComponent},
  {path: 'gallery', component: GalleryComponent},
  {path: 'login', component: LoginComponent},
  {path: 'previousProjects', component: PreviousProjectsComponent},
];
