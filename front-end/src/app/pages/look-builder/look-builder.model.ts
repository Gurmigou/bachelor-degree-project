import {FilePreview} from "../../shared/app-common-model.model";

export enum CLOTHES_ELEMENT_TYPE {
  HEADDRESS = 'Headdress',
  TORSO = 'Torso',
  LEGWEAR = 'Legwear',
  FEET = 'Feet',
  ACCESSORIES = 'Accessories',
  NOT_SELECTED = 'Not selected'
}


export type ClothesElement = {
  clothesElementName: string,
  images: FilePreview[],
  description: string
}

export type OutfitClothes = {
  headdress: ClothesElement[],
  torso: ClothesElement[],
  legwear: ClothesElement[],
  feet: ClothesElement[],
  accessories: ClothesElement[]

}

export type Outfit = {
  name: string,
  tags: string[],
  outfitClothes: OutfitClothes
}
