import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CLOTHES_ELEMENT_TYPE, ClothesElement, OutfitClothes} from '../../pages/look-builder/look-builder.model';

@Component({
  selector: 'app-look-preview-builder',
  templateUrl: './look-preview-builder.component.html',
  styleUrl: './look-preview-builder.component.css'
})
export class LookPreviewBuilderComponent {
  @Output()
  onCreateClothesItem =
    new EventEmitter<CLOTHES_ELEMENT_TYPE>();
  @Output()
  onDeleteClothesItem =
    new EventEmitter<{ type: CLOTHES_ELEMENT_TYPE; index: number }>();

  @Input()
  outfitClothes: OutfitClothes = {
    headdress: [],
    torso: [],
    legwear: [],
    feet: [],
    accessories: []
  }

  protected getTitleImages(item: ClothesElement[]) {
    return item.map((element) => element.images[0].preview as string);
  }

  onBuildElement(type: CLOTHES_ELEMENT_TYPE) {
    this.onCreateClothesItem.emit(type);
  }

  onDeleteItem($event: number, type: CLOTHES_ELEMENT_TYPE) {
    this.onDeleteClothesItem.emit({type, index: $event});
  }

  protected readonly CLOTHES_ELEMENT_TYPE = CLOTHES_ELEMENT_TYPE;
}
