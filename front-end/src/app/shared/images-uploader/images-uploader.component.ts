import {Component, EventEmitter, Output} from '@angular/core';
import {FilePreview} from "../app-common-model.model";

@Component({
  selector: 'app-images-uploader',
  templateUrl: './images-uploader.component.html',
  styleUrl: './images-uploader.component.css'
})
export class ImagesUploaderComponent {
  @Output()
  updateImageEmitter = new EventEmitter<FilePreview[]>();
  files: FilePreview[] = [];

  constructor() {
  }

  onDragOver(event: DragEvent): void {
    event.stopPropagation();
    event.preventDefault();
  }

  onFileDropped(event: any): void {
    console.log('event', event)
    event.preventDefault();
    const files = event.target.files || event.dataTransfer.files;
    console.log('files after event', files)
    this.processFiles(files);
  }

  private processFiles(files: FileList): void {
    Array.from(files).forEach(file => {
      if (file.type.match('image.*')) {
        const reader = new FileReader();
        reader.onload = (e: any) => {
          this.files.push({name: file.name, preview: e.target.result});
          this.updateImageEmitter.emit(this.files);
        };
        reader.readAsDataURL(file);
      }
    });
  }

  deleteFile(file: FilePreview) {
    this.files = this.files.filter(f => f !== file);
    this.updateImageEmitter.emit(this.files);
  }

  clearFiles() {
    this.files = [];
    this.updateImageEmitter.emit(this.files);
  }
}
