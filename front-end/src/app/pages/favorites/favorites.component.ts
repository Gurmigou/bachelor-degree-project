import {Component} from '@angular/core';
import {OutfitPreview} from "../../shared/app-common-model.model";
import {AppApiService} from "../../service/app-api.service";

@Component({
  selector: 'app-favorites',
  templateUrl: './favorites.component.html',
  styleUrl: './favorites.component.css'
})
export class FavoritesComponent {
  favoriteOutfits: OutfitPreview[] = [];

  constructor(private appApiService: AppApiService) {
    this.appApiService.getAllOutfitsPreview()
      .subscribe(outfitPreviews => {
        this.favoriteOutfits = outfitPreviews.filter(outfitPreview => outfitPreview.isFavorite);
      });
  }
}
