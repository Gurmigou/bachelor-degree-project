import {Routes} from "@angular/router";
import {LoginComponent} from "../pages/login/login.component";
import {RegistrationComponent} from "../pages/registration/registration.component";
import {NotFoundComponent} from "../pages/not-found/not-found.component";

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'register', component: RegistrationComponent},
  {path: '**', component: NotFoundComponent},
];
