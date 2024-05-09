import {Injectable} from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {Observable} from 'rxjs';
import {Outfit, OutfitPreview} from "../shared/app-common-model.model";

@Injectable({
  providedIn: 'root'
})
export class AppApiService {
  private static HOST: string = "http://localhost:8080";

  constructor(private httpClient: HttpClient) {
  }

  public saveNewOutfit(outfit: Outfit): Observable<any> {
    return this.httpClient.post(
      `${AppApiService.HOST}/outfits`, outfit);
  }

  public addCommentToOutfit(outfitId: number, comment: Comment): Observable<any> {
    return this.httpClient.post(
      `${AppApiService.HOST}/outfits/${outfitId}/comments`, comment);
  }

  public updateOutfit(outfit: Outfit): Observable<any> {
    return this.httpClient.put(
      `${AppApiService.HOST}/outfits`, outfit);
  }

  public deleteOutfit(outfitId: number): Observable<any> {
    return this.httpClient.delete(
      `${AppApiService.HOST}/outfits`, {params: {outfitId}});
  }

  public getOutfitById(id: number): Observable<Outfit> {
    return this.httpClient.get<Outfit>(
      `${AppApiService.HOST}/outfits/${id}`);
  }

  public getAllOutfitsPreview(): Observable<OutfitPreview[]> {
    return this.httpClient.get<OutfitPreview[]>(
      `${AppApiService.HOST}/outfits/all-preview`);
  }

  public getAllOutfitsPreviewForUser(userId: number): Observable<OutfitPreview[]> {
    return this.httpClient.get<OutfitPreview[]>(
      `${AppApiService.HOST}/outfits/all-preview-user`, {params: {userId}});
  }
}
