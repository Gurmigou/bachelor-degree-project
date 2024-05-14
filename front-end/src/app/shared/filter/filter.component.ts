import { Component, EventEmitter, Input, Output } from '@angular/core';

@Component({
  selector: 'app-filter',
  templateUrl: './filter.component.html',
  styleUrls: ['./filter.component.css']
})
export class FilterComponent {
  @Input() filterLabel: string = "";
  @Input() options: string[] = [];
  @Output() selectionChange = new EventEmitter<string[]>();

  constructor() { }

  onSelectionChange(event: any) {
    const selectedOptions = event.source.selectedOptions.selected.map((option: any) => option.value);
    this.selectionChange.emit(selectedOptions);
  }
}
