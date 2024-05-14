import {Component} from '@angular/core';
import {OutfitPreview} from "../../shared/app-common-model.model";
import {AppApiService} from "../../service/app-api.service";

@Component({
  selector: 'app-my-works',
  templateUrl: './my-works.component.html',
  styleUrl: './my-works.component.css'
})
export class MyWorksComponent {
  myOutfitPreviews: OutfitPreview[] = [];

  constructor(private appApiService: AppApiService) {
    // TODO: get userId from the session
    const userId = 1;
    this.appApiService.getAllOutfitsPreviewForUser(userId)
      .subscribe(outfitPreviews => {
        this.myOutfitPreviews = outfitPreviews;
      });
  }
}
