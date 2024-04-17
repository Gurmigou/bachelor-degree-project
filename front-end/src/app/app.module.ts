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
import {LogoTitleComponent} from "./shared/logo-title/logo-title.component";
import {NavBarComponent} from "./shared/nav-bar/nav-bar.component";
import {MarketComponent} from "./pages/market/market/market.component";
import {FooterComponent} from "./shared/footer/footer.component";
import {LookCardComponent} from "./shared/look-card/look-card.component";
import {StarRatingComponent} from "./shared/star-rating/star-rating.component";
import {SearchComponent} from "./shared/search/search.component";
import {FilterComponent} from "./shared/filter/filter.component";

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    NotFoundComponent,
    NavBarComponent,
    MarketComponent,
    FooterComponent,
    LookCardComponent,
    StarRatingComponent,
    SearchComponent,
    FilterComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule,
    MatCardModule, MatInputModule, MatButtonModule,
    FormsModule, MatFormFieldModule, MatCheckboxModule,
    MatSelectModule, ReactiveFormsModule, MatExpansionModule,
    MatIconModule, MatListModule, MatDatepickerModule,
    MatNativeDateModule, NgOptimizedImage, MatToolbarModule,
    MatSidenavModule, RouterLink, HttpClientModule,
    RouterModule.forRoot(routes), LogoTitleComponent
  ],
  providers: [HttpParams],
  bootstrap: [AppComponent],
  exports: [RouterModule]
})
export class AppModule {
}
