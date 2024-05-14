import {Component, ViewChild} from '@angular/core';
import {FormArray, FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {
  CLOTHES_ELEMENT_TYPE,
  ClothesElement,
  FilePreview,
  Outfit,
  OutfitClothes
} from "../../shared/app-common-model.model";
import {ImagesUploaderComponent} from "../../shared/images-uploader/images-uploader.component";
import {AppApiService} from "../../service/app-api.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-look-builder',
  templateUrl: './look-builder.component.html',
  styleUrl: './look-builder.component.css'
})
export class LookBuilderComponent {
  outfitFormGroup: FormGroup;
  elementFormGroup: FormGroup;

  @ViewChild('appImagesUploader')
  imagesUploaderComponent: ImagesUploaderComponent | undefined;

  currentElementType: CLOTHES_ELEMENT_TYPE = CLOTHES_ELEMENT_TYPE.NOT_SELECTED;

  constructor(private fb: FormBuilder,
              private appApiService: AppApiService,
              private router: Router) {
    // Form group for the whole outfit
    this.outfitFormGroup = this.fb.group({
      outfitName: [''],
      tags: this.fb.array([]),
      outfitClothes: this.fb.group({
        headdress: this.fb.array([]),
        torso: this.fb.array([]),
        legwear: this.fb.array([]),
        feet: this.fb.array([]),
        accessories: this.fb.array([])
      })
    });

    // Form group for the element of the outfit
    this.elementFormGroup = this.createFormGroupForElement();
  }

  private createFormGroupForElement(): FormGroup {
    return this.fb.group({
      outfitElementName: [''],
      images: this.fb.array([]),
      description: [''],
      brand: ['']
    });
  }

  onSaveOutfit() {
    const outfit: Outfit = {
      name: this.outfitFormGroup.get('outfitName')?.value,
      tags: this.outfitFormGroup.get('tags')?.value,
      outfitClothes: {
        headdress: this.outfitFormGroup.get('outfitClothes.headdress')?.value,
        torso: this.outfitFormGroup.get('outfitClothes.torso')?.value,
        legwear: this.outfitFormGroup.get('outfitClothes.legwear')?.value,
        feet: this.outfitFormGroup.get('outfitClothes.feet')?.value,
        accessories: this.outfitFormGroup.get('outfitClothes.accessories')?.value
      }
    }
    this.appApiService.saveNewOutfit(outfit)
      .subscribe(() => {
          console.log('after save')
          this.router.navigate(["/my-works"])
        }
      )
  }

  get tags(): FormArray {
    return this.outfitFormGroup.get('tags') as FormArray;
  }

  get elementImages(): FormArray {
    return this.elementFormGroup.get('images') as FormArray;
  }

  public addTag(tag: string) {
    this.tags.push(new FormControl(tag));
  }

  public updateElementImages(files: FilePreview[]) {
    files.forEach(file => {
      this.elementImages.push(new FormControl(file));
    });
  }

  onSaveOutfitElement() {
    const element: ClothesElement = {
      clothesElementName: this.elementFormGroup.get('outfitElementName')?.value,
      images: this.elementFormGroup.get('images')?.value,
      brand: this.elementFormGroup.get('brand')?.value,
      description: this.elementFormGroup.get('description')?.value,
      type: this.currentElementType
    }
    const formArray = this.currentFormArray;
    formArray.push(new FormControl(element));
    this.elementFormGroup = this.createFormGroupForElement();
    this.currentElementType = CLOTHES_ELEMENT_TYPE.NOT_SELECTED;
    this.imagesUploaderComponent?.clearFiles();
  }

  get currentFormArray(): FormArray {
    const elementType = this.currentElementType.toLowerCase();
    return (this.outfitFormGroup.get('outfitClothes') as FormGroup).get(elementType) as FormArray;
  }

  onCreateClothesItem($event: CLOTHES_ELEMENT_TYPE) {
    this.currentElementType = $event;
  }

  onDeleteClothesItem($event: { type: CLOTHES_ELEMENT_TYPE, index: number }) {
    const elementType = $event.type.toLowerCase();
    const formArray = (this.outfitFormGroup.get('outfitClothes') as FormGroup)
      .get(elementType) as FormArray;
    formArray.removeAt($event.index);
  }

  getOutfitClothes(): OutfitClothes {
    return {
      headdress: this.outfitFormGroup.get('outfitClothes.headdress')?.value,
      torso: this.outfitFormGroup.get('outfitClothes.torso')?.value,
      legwear: this.outfitFormGroup.get('outfitClothes.legwear')?.value,
      feet: this.outfitFormGroup.get('outfitClothes.feet')?.value,
      accessories: this.outfitFormGroup.get('outfitClothes.accessories')?.value
    }
  }
}
