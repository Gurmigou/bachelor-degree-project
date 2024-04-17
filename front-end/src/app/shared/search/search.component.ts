import { Component } from '@angular/core';

@Component({
  selector: 'app-search',
  templateUrl: './search.component.html',
  styleUrls: ['./search.component.css']
})
export class SearchComponent {
  // The search term
  searchTerm: string = '';

  // Method to handle the search logic
  // This should ideally call a service that handles the search logic
  onSearch(): void {
    console.log(`Searching for: ${this.searchTerm}`);
    // Implement the search logic here or call a service method
  }
}
