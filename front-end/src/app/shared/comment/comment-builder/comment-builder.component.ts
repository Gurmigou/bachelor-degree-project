import {Component, EventEmitter, Output} from '@angular/core';
import {convertToRateEnum, OutfitComment, RATE} from "../../app-common-model.model";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-comment-builder',
  templateUrl: './comment-builder.component.html',
  styleUrl: './comment-builder.component.css'
})
export class CommentBuilderComponent {
  @Output()
  onSaveNewComment = new EventEmitter<OutfitComment>();
  formGroup: FormGroup;

  constructor(private fb: FormBuilder) {
    this.formGroup = this.fb.group({
      "commentText": [""],
      "rate": [RATE.STAR_0]
    });
  }

  protected readonly RATE = RATE;

  onSaveComment() {
    const newComment = this.formGroup.value as OutfitComment;
    this.onSaveNewComment.emit(newComment);
    this.clearForm();
  }

  onRateUpdate(rate: number) {
    this.formGroup.get("rate")?.setValue(convertToRateEnum(rate));
  }

  private clearForm() {
    this.formGroup.reset();
    this.formGroup.get("rate")?.setValue(RATE.STAR_0);
  }

  get rate(): RATE {
    return this.formGroup.get("rate")?.value;
  }
}
