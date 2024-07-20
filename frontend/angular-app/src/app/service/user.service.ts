import { Injectable } from '@angular/core';
import { environment } from '../environment/environment';
import { HttpClient } from '@angular/common/http';
import { Credentials } from '../model/credentials';
import { Observable } from 'rxjs';
import { CustomResponse } from '../model/customResponse';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly baseUrl = environment.backendUrl + "/api/users";

  constructor(private http: HttpClient) {}

  login(credentials: Credentials): Observable<CustomResponse> {
    return this.http.post<CustomResponse>(this.baseUrl+'/login', credentials);
  }

  getAllUsers(): Observable<any> {
    return this.http.get(environment.backendUrl+'/api/users');
  }
}
