import {FilePreview} from "../../shared/app-common-model.model";

export enum CLOTHES_ELEMENT_TYPE {
  HEADDRESS = 'Headdress',
  TORSO = 'Torso',
  LEGWEAR = 'Legwear',
  FEET = 'Feet',
  ACCESSORIES = 'Accessories',
  NOT_SELECTED = 'Not selected'
}

export enum RATE {
  STAR_0 = 0,
  STAR_1 = 1,
  STAR_2 = 2,
  STAR_3 = 3,
  STAR_4 = 4,
  STAR_5 = 5
}

export type ClothesElement = {
  clothesElementName: string,
  images: FilePreview[],
  tags?: string[]
  description: string,
  type: CLOTHES_ELEMENT_TYPE
}

export type OutfitClothes = {
  headdress: ClothesElement[],
  torso: ClothesElement[],
  legwear: ClothesElement[],
  feet: ClothesElement[],
  accessories: ClothesElement[]
}

export type OutfitComment = {
  username: string,
  commentText: string,
  rate: RATE,
  dateOfCreation: Date
}

export type Outfit = {
  name: string,
  tags: string[],
  outfitClothes: OutfitClothes,
  comments?: OutfitComment[]
}

export type OutfitClothesPreview = {
  headdress: FilePreview,
  torso: FilePreview,
  legwear: FilePreview,
  feet: FilePreview,
  accessories: FilePreview
}

export type OutfitPreview = {
  designerName: string,
  numberOfComments: number,
  rate: RATE,
  outfitClothesPreview: OutfitClothesPreview
}
