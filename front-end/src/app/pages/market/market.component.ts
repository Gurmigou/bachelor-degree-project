import {Component} from '@angular/core';
import {AppApiService} from "../../service/app-api.service";
import {LabelCount, OutfitPreview} from "../../shared/app-common-model.model";

@Component({
  selector: 'app-market',
  templateUrl: './market.component.html',
  styleUrl: './market.component.css'
})
export class MarketComponent {
  outfitPreviews: OutfitPreview[] = [];
  brands: LabelCount[] = [];
  tags: LabelCount[] = [];
  selectedBrands: string[] = [];
  selectedTags: string[] = [];

  constructor(private appApiService: AppApiService) {
    this.appApiService.getAllOutfitsPreview().subscribe(outfitPreviews => {
      this.outfitPreviews = outfitPreviews;
    });
    this.appApiService.getStaticBrandsList().subscribe(brands => {
      this.brands = brands;
    });
    this.appApiService.getStaticTagsList().subscribe(tags => {
      this.tags = tags;
    });
  }

  convertToStrings(labelCounts: LabelCount[]): string[] {
    return labelCounts.map(labelCount => labelCount.label);
  }

  onBrandSelectionChange(selectedBrands: string[]) {
    this.selectedBrands = selectedBrands;
  }

  onTagSelectionChange(selectedTags: string[]) {
    this.selectedTags = selectedTags;
  }

  onApplyFilters() {
    if (this.selectedBrands.length === 0 && this.selectedTags.length === 0) {
      return;
    }

    this.appApiService.getOutfitsPreviewByFilter(this.selectedBrands, this.selectedTags)
      .subscribe(outfitPreviews => {
        this.outfitPreviews = outfitPreviews;
      });
  }
}
