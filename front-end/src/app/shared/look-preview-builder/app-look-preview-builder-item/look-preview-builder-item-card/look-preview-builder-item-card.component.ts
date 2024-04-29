import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-look-preview-builder-item-card',
  templateUrl: './look-preview-builder-item-card.component.html',
  styleUrl: './look-preview-builder-item-card.component.css'
})
export class LookPreviewBuilderItemCardComponent {
  @Input()
  image: string = ""

  @Output()
  onDeleteItemEmitter = new EventEmitter<string>();

  onDeleteItem() {
    this.onDeleteItemEmitter.emit(this.image);
  }
}
