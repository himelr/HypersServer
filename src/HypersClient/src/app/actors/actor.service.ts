import { Injectable } from '@angular/core';
import { Observable } from 'rxjs/Observable';
import { of } from 'rxjs/observable/of';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable()
export class ActorService {
  private actorUrl = '/api/response';
  getMessages (amount: number = 1): Observable<string[]> {
    return this.http.get<string[]>(this.actorUrl + '/' + amount)
    .pipe(
      catchError(this.handleError('getMessages', []))
    );
  }
  constructor(private http: HttpClient) {
  }
  private handleError<T> (operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      // TODO: send the error to remote logging infrastructure
      console.error(error); // log to console instead
      // TODO: better job of transforming error for user consumptio
      // Let the app keep running by returning an empty result.
      return of(result as T);
    };
}
}
