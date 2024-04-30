import {Component, Input} from '@angular/core';

@Component({
  selector: 'app-look-card',
  templateUrl: './look-card.component.html',
  styleUrl: './look-card.component.css'
})
export class LookCardComponent {
  @Input()
  favoritesButton: boolean = true;
}
