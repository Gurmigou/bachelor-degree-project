import {Routes} from "@angular/router";
import {LoginComponent} from "../pages/login/login.component";
import {RegistrationComponent} from "../pages/registration/registration.component";
import {NotFoundComponent} from "../pages/not-found/not-found.component";
import {MarketComponent} from "../pages/market/market/market.component";

export const routes: Routes = [
  {path: 'login', component: LoginComponent},
  {path: 'sign-up', component: RegistrationComponent},
  {path: 'market', component: MarketComponent},
  {path: '**', component: NotFoundComponent},
];
