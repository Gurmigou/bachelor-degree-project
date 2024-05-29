import {Component, EventEmitter, Input, Output} from '@angular/core';
import {OutfitPreview} from "../app-common-model.model";
import {AppApiService} from "../../service/app-api.service";
import {Event, Router} from "@angular/router";

@Component({
  selector: 'app-look-card',
  templateUrl: './look-card.component.html',
  styleUrl: './look-card.component.css'
})
export class LookCardComponent {
  @Input() favoritesButton: boolean = true;
  @Input() deletable: boolean = false;
  @Input() editable: boolean = false;
  @Input() outfitPreview: OutfitPreview | undefined;

  @Output() onEditClickEmitter = new EventEmitter<number>();
  @Output() onDeleteClickEmitter = new EventEmitter<number>();

  constructor(private appApiService: AppApiService,
              private router: Router) {
  }

  onRateChange(isFavorite: boolean, $event: any) {
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

  onEditClick($event: any) {
    $event.stopPropagation();
    if (this.outfitPreview) {
      this.onEditClickEmitter.emit(this.outfitPreview.id);
    }
  }

  onDeleteClick($event: any) {
    $event.stopPropagation();
    if (this.outfitPreview) {
      this.onDeleteClickEmitter.emit(this.outfitPreview.id);
    }
  }
}
