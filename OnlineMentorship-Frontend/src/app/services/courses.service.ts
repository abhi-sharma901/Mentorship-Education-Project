import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
const baseUrl =['http://localhost:8091/onlineMentorship/guest'];
@Injectable({
  providedIn: 'root'
})
export class CoursesService {
  constructor(private http: HttpClient) { }

  getAllCourses(): Observable<any> {
    return this.http.get(baseUrl + "/viewCourses");
  }

  // getCurrentCourse(course:any){
  //   return course;
  // }
  setCurrentCourse(course:any){
    console.log(course)
    localStorage.setItem('course',JSON.stringify(course));
  }
  getCurrentCourseId(){
    let s =localStorage.getItem("course");
    if(s!= null) {
      let course = JSON.parse(s);
      return course.courseId;
    }
    return null;
    // return localStorage.getItem('courseId');
  }
  getCurrentCourseCost(){
    let s =localStorage.getItem("course");
    if(s!= null) {
      let course = JSON.parse(s);
      return course.courseCost
    }
    return null;
  }
  getCurrentCourseName(){
    let s =localStorage.getItem("course");
    if(s!= null) {
      let course = JSON.parse(s);
      return course.courseName
    }
    return null;
  }
}
