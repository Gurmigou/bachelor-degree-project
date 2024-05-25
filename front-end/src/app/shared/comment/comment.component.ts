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
}
