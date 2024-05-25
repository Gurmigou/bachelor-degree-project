import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-look-preview-item',
  templateUrl: './look-preview-item.component.html',
  styleUrl: './look-preview-item.component.css'
})
export class LookPreviewItemComponent {
  @Input()
  typeLabel: string = "";

  @Input()
  images: [number, string][] = [];

  @Output()
  selectClothesElementById = new EventEmitter<number>()

  onImageClick(clothesElementId: number): void {
    this.selectClothesElementById.emit(clothesElementId)
  }
}
