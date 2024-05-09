import {Inject, Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Outfit} from "./look-builder.model";

@Injectable({
  providedIn: 'root'
})
export class LookBuilderService {
  private httpClient: HttpClient;

  constructor(httpClient: HttpClient) {
    this.httpClient = httpClient;
  }

  public saveNewOutfit(outfit: Outfit): Observable<any> {
    return this.httpClient.post<void>("http://localhost:8080/outfits", outfit, {})
  }
}
