import {Component} from '@angular/core';
import {OutfitPreview} from "../../shared/app-common-model.model";
import {AppApiService} from "../../service/app-api.service";

@Component({
  selector: 'app-magic-search',
  templateUrl: './magic-search.component.html',
  styleUrl: './magic-search.component.css'
})
export class MagicSearchComponent {
  outfitPreviews: OutfitPreview[] = [];

  constructor(private appApiService: AppApiService) {
  }

  onApplyMagicSearch() {

  }
}
