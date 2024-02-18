import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {UserService} from "./user.service";
import {CoursesService} from "./courses.service";
import {MentorshipsService} from "./mentorships.service";
import {MatSnackBar} from "@angular/material/snack-bar";

const baseUrl ='http://localhost:8091/onlineMentorship/student';
@Injectable({
  providedIn: 'root'
})
export class EnrollStudentService {

  constructor(private http: HttpClient,private snack:MatSnackBar, private userService:UserService,private mentroshipService: MentorshipsService, private courseService: CoursesService) { }
  enrollCourse( paymentDetail:any) {
    let sid = this.userService.getUserId();
    console.log(sid);
    let cid = this.courseService.getCurrentCourseId();
   return this.http.post(`${baseUrl}/course/${sid}/${cid}/payment`, paymentDetail)
  }
  enrollMentroship(paymentDetail: any){
    let sid = this.userService.getUserId();
    console.log(sid);
    let mid = this.mentroshipService.getCurrentMentorshipId();
    return this.http.post(`${baseUrl}/mentorship/${sid}/${mid}/payment`, paymentDetail);
  }

}
