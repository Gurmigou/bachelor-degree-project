export interface FilePreview {
  name: string;
  preview: string | ArrayBuffer;
}

export enum CLOTHES_ELEMENT_TYPE {
  HEADDRESS = 'Headdress',
  TORSO = 'Torso',
  LEGWEAR = 'Legwear',
  FEET = 'Feet',
  ACCESSORIES = 'Accessories',
  NOT_SELECTED = 'not selected'
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
  id?: number,
  clothesElementName: string,
  images: FilePreview[],
  tags?: string[]
  description: string,
  brand: string,
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
  id?: number
  name: string,
  tags: string[],
  outfitClothes: OutfitClothes,
}

export type OutfitDetails = Outfit & {
  comments?: OutfitComment[],
  designerName: string,
  isFavorite: boolean,
  rate: RATE,
  numberOfComments: number
}

export type OutfitClothesPreview = {
  headdress: FilePreview,
  torso: FilePreview,
  legwear: FilePreview,
  feet: FilePreview,
  accessories: FilePreview
}

export type OutfitPreview = {
  id: number,
  designerName: string,
  numberOfComments: number,
  rate: RATE,
  isFavorite: boolean,
  outfitClothesPreview: OutfitClothesPreview
}

export type LabelCount = {
  label: string,
  count: number
}

export type PreviewFavorite = {
  outfitId: number,
  isFavorite: boolean
}

export function convertToRateEnum(rating: number): RATE {
  switch (rating) {
    case 0:
      return RATE.STAR_0;
    case 1:
      return RATE.STAR_1;
    case 2:
      return RATE.STAR_2;
    case 3:
      return RATE.STAR_3;
    case 4:
      return RATE.STAR_4;
    case 5:
      return RATE.STAR_5;
    default:
      throw new Error("Invalid rating");
  }
}
