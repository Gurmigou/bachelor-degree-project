import {Component, Input} from '@angular/core';
import {OutfitPreview} from "../app-common-model.model";
import {AppApiService} from "../../service/app-api.service";

@Component({
  selector: 'app-look-card',
  templateUrl: './look-card.component.html',
  styleUrl: './look-card.component.css'
})
export class LookCardComponent {
  @Input()
  favoritesButton: boolean = true;

  @Input()
  outfitPreview: OutfitPreview | undefined;

  constructor(private appApiService: AppApiService) {
  }

  onRateChange(isFavorite: boolean) {
    console.log('onRateChange', isFavorite);
    if (this.outfitPreview) {
      this.outfitPreview.isFavorite = isFavorite;
    }
    this.appApiService.makeOutfitFavoriteState(this.outfitPreview?.id, isFavorite).subscribe()
  }
}
