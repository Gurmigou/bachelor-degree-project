import {Component, Input} from '@angular/core';
import {OutfitPreview} from "../app-common-model.model";
import {AppApiService} from "../../service/app-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-look-card',
  templateUrl: './look-card.component.html',
  styleUrl: './look-card.component.css'
})
export class LookCardComponent {
  @Input()
  favoritesButton: boolean = true;

  @Input()
  deletable: boolean = false;

  @Input()
  editable: boolean = false;

  @Input()
  outfitPreview: OutfitPreview | undefined;

  constructor(private appApiService: AppApiService,
              private router: Router) {
  }

  onRateChange(isFavorite: boolean, $event: Event) {
    $event.stopPropagation()
    if (this.outfitPreview) {
      this.outfitPreview.isFavorite = isFavorite;
    }
    this.appApiService.makeOutfitFavoriteState(this.outfitPreview?.id, isFavorite).subscribe()
  }

  redirectToOutfitDetailedInfo() {
    if (this.outfitPreview) {
      this.router.navigate(["/look-details", this.outfitPreview.id]);
    }
  }
}
