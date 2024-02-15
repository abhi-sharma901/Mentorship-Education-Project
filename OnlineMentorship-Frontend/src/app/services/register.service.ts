import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";

const  baseUrl = 'http://localhost:8091/api';
@Injectable({
  providedIn: 'root'
})
export class RegisterService {

  constructor(private http:HttpClient) { }
  public register(userData: any){
    return this.http.post(`${baseUrl}/register`,userData);
  }
}
