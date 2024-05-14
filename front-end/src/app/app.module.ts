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
import {MatLine, MatNativeDateModule} from "@angular/material/core";
import {NgOptimizedImage} from "@angular/common";
import {MatToolbarModule} from "@angular/material/toolbar";
import {MatSidenavModule} from "@angular/material/sidenav";
import {RouterLink, RouterModule} from "@angular/router";
import {HttpClientModule, HttpParams} from "@angular/common/http";
import {routes} from "./routes/Routes";
import {LogoTitleComponent} from "./shared/logo-title/logo-title.component";
import {NavBarComponent} from "./shared/nav-bar/nav-bar.component";
import {MarketComponent} from "./pages/market/market.component";
import {FooterComponent} from "./shared/footer/footer.component";
import {LookCardComponent} from "./shared/look-card/look-card.component";
import {StarRatingComponent} from "./shared/star-rating/star-rating.component";
import {SearchComponent} from "./shared/search/search.component";
import {FilterComponent} from "./shared/filter/filter.component";
import {TagComponent} from "./shared/tag/tag.component";
import {LookDetailsComponent} from "./pages/look-details/look-details.component";
import {LookPreviewItemComponent} from "./shared/look-preview/look-preview-item/look-preview-item.component";
import {LookPreviewComponent} from "./shared/look-preview/look-preview.component";
import {ImgCarouselComponent} from "./shared/img-carousel/img-carousel.component";
import {CommentComponent} from "./shared/comment/comment.component";
import {LookBuilderComponent} from "./pages/look-builder/look-builder.component";
import {TagListBuilderComponent} from "./shared/tag-list-builder/tag-list-builder.component";
import {LookPreviewBuilderComponent} from "./shared/look-preview-builder/look-preview-builder.component";
import {
  AppLookPreviewBuilderItemComponent
} from "./shared/look-preview-builder/app-look-preview-builder-item/app-look-preview-builder-item.component";
import {ImagesUploaderComponent} from "./shared/images-uploader/images-uploader.component";
import {
  LookPreviewBuilderItemCardComponent
} from "./shared/look-preview-builder/app-look-preview-builder-item/look-preview-builder-item-card/look-preview-builder-item-card.component";
import {MyWorksComponent} from "./pages/my-works/my-works.component";
import {EditableLookCardComponent} from "./shared/editable-look-card/editable-look-card.component";
import {FavoritesComponent} from "./pages/favorites/favorites.component";
import {MagicSearchComponent} from "./pages/magic-search/magic-search.component";

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
    FilterComponent,
    TagComponent,
    LookDetailsComponent,
    LookPreviewItemComponent,
    LookPreviewComponent,
    ImgCarouselComponent,
    CommentComponent,
    LookBuilderComponent,
    TagListBuilderComponent,
    LookPreviewBuilderComponent,
    AppLookPreviewBuilderItemComponent,
    ImagesUploaderComponent,
    LookPreviewBuilderItemCardComponent,
    MyWorksComponent,
    EditableLookCardComponent,
    FavoritesComponent,
    MagicSearchComponent
  ],
  imports: [
    BrowserModule, BrowserAnimationsModule,
    MatCardModule, MatInputModule, MatButtonModule,
    FormsModule, MatFormFieldModule, MatCheckboxModule,
    MatSelectModule, ReactiveFormsModule, MatExpansionModule,
    MatIconModule, MatListModule, MatDatepickerModule,
    MatNativeDateModule, NgOptimizedImage, MatToolbarModule,
    MatSidenavModule, RouterLink, HttpClientModule,
    RouterModule.forRoot(routes), LogoTitleComponent, MatLine
  ],
  providers: [HttpParams],
  bootstrap: [AppComponent],
  exports: [RouterModule, TagComponent, StarRatingComponent, LookCardComponent]
})
export class AppModule {
}
