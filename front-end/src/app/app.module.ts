import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {LoginComponent} from "./pages/login/login.component";
import {RegistrationComponent} from "./pages/registration/registration.component";
import {NotFoundComponent} from "./pages/not-found/not-found.component";
import {BrowserModule} from "@angular/platform-browser";
import {BrowserAnimationsModule} from "@angular/platform-browser/animations";
import {MatCardModule} from "@angular/material/card";
import {MatInputModule} from "@angular/material/input";
import {MatButtonModule} from "@angular/material/button";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatSelectModule} from "@angular/material/select";
import {MatExpansionModule} from "@angular/material/expansion";
import {MatIconModule} from "@angular/material/icon";
import {MatListModule} from "@angular/material/list";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule} from "@angular/material/core";
import {NgOptimizedImage} from "@angular/common";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {RouterLink, RouterModule} from "@angular/router";
import {HttpClientModule, HttpParams} from "@angular/common/http";
import {routes} from "./routes/Routes";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    NotFoundComponent,
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule,
    MatCardModule, MatInputModule, MatButtonModule,
    FormsModule, MatFormFieldModule, MatCheckboxModule,
    MatSelectModule, ReactiveFormsModule, MatExpansionModule,
    MatIconModule, MatListModule, MatDatepickerModule,
    MatNativeDateModule, NgOptimizedImage, MatToolbarModule,
    MatSidenavModule, RouterLink, HttpClientModule,
    RouterModule.forRoot(routes)
  ],
  providers: [HttpParams],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule {
}
