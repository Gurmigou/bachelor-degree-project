import {Component, Input} from '@angular/core';
import {OutfitComment} from "../app-common-model.model";

@Component({
  selector: 'app-comment',
  templateUrl: './comment.component.html',
  styleUrl: './comment.component.css'
})
export class CommentComponent {
  @Input()
  outfitComment: OutfitComment | undefined

  getFormattedDate(dateOfCreation: Date | undefined) {
    if (!dateOfCreation) {
      return ''
    }
    const date = new Date(dateOfCreation)
    return `${date.getDate()}.${date.getMonth() + 1}.${date.getFullYear()} ${date.getHours()}:${date.getMinutes()}`
  }
}
