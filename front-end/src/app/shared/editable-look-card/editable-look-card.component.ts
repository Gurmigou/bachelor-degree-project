import {Component, Input} from '@angular/core';
import {OutfitPreview} from "../app-common-model.model";

@Component({
  selector: 'app-editable-look-card',
  templateUrl: './editable-look-card.component.html',
  styleUrl: './editable-look-card.component.css'
})
export class EditableLookCardComponent {
  @Input()
  deletable: boolean = true;

  @Input()
  editable: boolean = true;

  @Input()
  favoritesButton: boolean = true;

  @Input()
  outfitPreview: OutfitPreview | undefined;
}
