import {Component, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {AppApiService} from "../../service/app-api.service";
import {ClothesElement, Outfit, OutfitComment, OutfitDetails} from "../../shared/app-common-model.model";
import {concatMap, map, tap} from "rxjs";

@Component({
  selector: 'app-look-details',
  templateUrl: './look-details.component.html',
  styleUrl: './look-details.component.css'
})
export class LookDetailsComponent implements OnInit {
  outfitId: number | undefined;
  outfit: OutfitDetails | undefined;
  currentClothesElement: ClothesElement | undefined

  constructor(private apiService: AppApiService,
              private route: ActivatedRoute) {
  }

  ngOnInit(): void {
    this.route.params.pipe(
      map(params => +params['outfitId']),
      tap(outfitId => this.outfitId = outfitId as number),
      concatMap(outfitId => this.apiService.getOutfitById(outfitId))
    ).subscribe(outfit => {
        this.outfit = outfit;
      }
    )
  }

  getCurrentClothesElementImages(): string[] {
    return this.currentClothesElement?.images
      .map(fp => fp.preview as string)!!
  }

  onSelectClothesElement(clothesElement: ClothesElement) {
    this.currentClothesElement = clothesElement;
  }

  onSaveNewComment(outfitComment: OutfitComment) {
    this.apiService.saveNewComment(outfitComment, this.outfitId!!)
      .subscribe(newComment =>
        this.outfit?.comments?.push(newComment));
  }
}
