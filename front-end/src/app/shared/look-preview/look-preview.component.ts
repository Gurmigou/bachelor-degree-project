import {Component, EventEmitter, Input, Output} from '@angular/core';
import {CLOTHES_ELEMENT_TYPE, ClothesElement, OutfitClothes} from "../app-common-model.model";

@Component({
  selector: 'app-look-preview',
  templateUrl: './look-preview.component.html',
  styleUrl: './look-preview.component.css'
})
export class LookPreviewComponent {
  @Input()
  outfitClothes: OutfitClothes | undefined

  @Output()
  selectClothesElementEmitter =
    new EventEmitter<ClothesElement>()

  constructor() {
  }

  selectClothesElement(clothesElementId: number) {
    const clothesElements = [
      ...this.outfitClothes?.feet!!,
      ...this.outfitClothes?.headdress!!,
      ...this.outfitClothes?.torso!!,
      ...this.outfitClothes?.legwear!!,
      ...this.outfitClothes?.feet!!,
      ...this.outfitClothes?.accessories!!
    ]
    const clothesElement = clothesElements.filter(ce =>
      ce.id == clothesElementId)[0]
    this.selectClothesElementEmitter.emit(clothesElement);
  }

  getImagesByType(type: CLOTHES_ELEMENT_TYPE): [number, string][] {
    if (type == CLOTHES_ELEMENT_TYPE.HEADDRESS)
      return this.mapClothesElementsToImages(this.outfitClothes?.headdress)
    if (type == CLOTHES_ELEMENT_TYPE.TORSO)
      return this.mapClothesElementsToImages(this.outfitClothes?.torso)
    if (type == CLOTHES_ELEMENT_TYPE.LEGWEAR)
      return this.mapClothesElementsToImages(this.outfitClothes?.legwear)
    if (type == CLOTHES_ELEMENT_TYPE.FEET)
      return this.mapClothesElementsToImages(this.outfitClothes?.feet)
    if (type == CLOTHES_ELEMENT_TYPE.ACCESSORIES)
      return this.mapClothesElementsToImages(this.outfitClothes?.accessories)
    return []
  }

  private mapClothesElementsToImages(clothesElements: ClothesElement[] | undefined): [number, string][] {
    if (!clothesElements) return []
    return clothesElements?.map(ce => [ce.id!!, ce.images[0].preview as string])
  }

  protected readonly CLOTHES_ELEMENT_TYPE = CLOTHES_ELEMENT_TYPE;
}
