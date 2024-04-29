import {Component, EventEmitter, Input, Output} from '@angular/core';

@Component({
  selector: 'app-app-look-preview-builder-item',
  templateUrl: './app-look-preview-builder-item.component.html',
  styleUrl: './app-look-preview-builder-item.component.css'
})
export class AppLookPreviewBuilderItemComponent {
  @Input()
  images: string[] = [];

  @Output()
  onDeleteItemEmitter = new EventEmitter<number>();

  onDeleteItem(image: string) {
    this.onDeleteItemEmitter.emit(this.images.indexOf(image));
  }
}
