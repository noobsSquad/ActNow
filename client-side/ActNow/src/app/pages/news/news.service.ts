import { Injectable } from '@angular/core';
import { HttpClient } from "@angular/common/http";
import { Observable, throwError } from 'rxjs';
import { catchError, map, retry } from 'rxjs/operators';
import { NewsContent } from './news-content.payload';
import { analyzeAndValidateNgModules } from '@angular/compiler';


@Injectable({
  providedIn: 'root'
})
export class NewsService {

  news: NewsContent[];
  item: NewsContent;
  testUrl = "assets/BingNewsData.json"
  count =0;

  constructor(private httpClient: HttpClient) { this.count =0;}

  getTestData(): Observable<any> {
    return this.httpClient.get("assets/dummy-data/BingNewsData.json");
      }
}
