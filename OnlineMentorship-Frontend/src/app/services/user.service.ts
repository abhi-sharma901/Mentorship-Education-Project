import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

const  baseUrl = 'http://localhost:8091/api';
@Injectable({
  providedIn: 'root'
})


export class UserService {
  constructor(private http:HttpClient) { }

  public addUser(user: any){
    return this.http.post(`${baseUrl}/login`,user);
  }
}
