import { Component } from '@angular/core';
import {CoursesService} from "../../../services/courses.service";
import {LoginService} from "../../../services/login.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-student-enrollments',
  templateUrl: './student-enrollments.component.html',
  styleUrls: ['./student-enrollments.component.css']
})
export class StudentEnrollmentsComponent {

  courses: any = [];
  mentorships:any =[]
  viewCourses = false;
  viewMentorships = false;
  constructor(private userService:UserService, private route:ActivatedRoute, private router:Router) { }

  getAllMyCourses() {
    this.viewCourses=true;
    this.userService.getStudentAllCourses().subscribe((res) => {
      console.log(res);
      this.courses = res;
    })
  }
  getAllMyMentorships() {
    this.viewMentorships = true;
    this.userService.getStudentAllMentorships().subscribe((res) => {
      console.log(res);
      this.mentorships = res;
    })
  }
}
