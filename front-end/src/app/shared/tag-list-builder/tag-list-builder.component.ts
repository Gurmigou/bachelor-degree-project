import {Component, EventEmitter, Output} from '@angular/core';
import {FormControl, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-tag-list-builder',
  templateUrl: './tag-list-builder.component.html',
  styleUrl: './tag-list-builder.component.css'
})
export class TagListBuilderComponent {
  tagFormGroup: FormGroup;

  @Output()
  addTagEmitter: EventEmitter<string> = new EventEmitter<string>();

  constructor() {
    this.tagFormGroup = new FormGroup({
      'newTag': new FormControl(''),
      'addedTags': new FormControl([])
    });
  }

  getAddedTags() {
    return this.tagFormGroup.get('addedTags')?.value;
  }

  addTag(tag: string) {
    const tagsControl = this.tagFormGroup.get('addedTags');
    if (tagsControl && tagsControl.value) {
      const tags = tagsControl.value;
      tags.push(tag);
      tagsControl.setValue(tags);
    }
  }

  onAdd() {
    const newTag = this.tagFormGroup.get('newTag')?.value;
    if (newTag) {
      this.addTag(newTag);
      this.addTagEmitter?.emit(newTag);
      this.tagFormGroup.get('newTag')?.setValue('');
    }
  }
}
