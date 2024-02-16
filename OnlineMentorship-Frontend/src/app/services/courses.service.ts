import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl =['http://localhost:8091/onlineMentorship/guest'];
@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  constructor(private http: HttpClient) { }

  getAllCustomers(): Observable<any> {
    return this.http.get(baseUrl + "/viewCourses");
  }

}
