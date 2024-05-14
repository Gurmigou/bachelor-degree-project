import { Component, EventEmitter, Input, OnInit, Output, ViewEncapsulation } from '@angular/core';
import {RATE} from "../app-common-model.model";

@Component({
  selector: 'app-star-rating',
  templateUrl: './star-rating.component.html',
  styleUrls: ['./star-rating.component.css'],
  encapsulation: ViewEncapsulation.Emulated
})
export class StarRatingComponent implements OnInit {

  @Input('rating') rating: RATE | undefined = 1;
  @Input('starCount') starCount: number = 5;
  @Input() clickable: boolean = false;
  @Output() private ratingUpdated = new EventEmitter();

  ratingArr: number[] = [];

  constructor() { }

  ngOnInit() {
    for (let index = 0; index < this.starCount; index++) {
      this.ratingArr.push(index);
    }
  }

  onClick(rating: number) {
    if (this.clickable) {
      this.ratingUpdated.emit(rating);
      this.rating = rating;
    }
    return false;
  }

  showIcon(index: number): string {
    // @ts-ignore
    if (this.rating?.valueOf() > index) {
      return 'assets/images/star.svg';
    } else {
      return 'assets/images/star_border.svg';
    }
  }
}
