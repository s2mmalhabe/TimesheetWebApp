import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from '../environment/environment';
import { Observable } from 'rxjs';
import { CustomResponse } from '../model/customResponse';
import { Calendar } from '../model/calendar';

@Injectable({
  providedIn: 'root'
})
export class CalendarService {
  private readonly baseUrl = environment.backendUrl + "/api/calendar";

  constructor(private http: HttpClient) {}

  saveCalendar(calendar: Calendar): Observable<CustomResponse> {
    return this.http.post<CustomResponse>(this.baseUrl, calendar);
  }
}
