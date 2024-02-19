import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {MentorshipsService} from "../../../services/mentorships.service";
import {CoursesService} from "../../../services/courses.service";
import {combineLatestAll} from "rxjs";

@Component({
  selector: 'app-trainer-view-student',
  templateUrl: './trainer-view-student.component.html',
  styleUrls: ['./trainer-view-student.component.css']
})
export class TrainerViewStudentComponent {
  courses: any = [];
  mentorships:any =[]
  viewCourses = false;
  viewMentorships = false;
  constructor(private userService:UserService, private mentorshipService:MentorshipsService, private courseService:CoursesService) { }
ngOnInit(){
    if(localStorage.getItem('viewCourse') == "true")
      this.getAllCourseStudents()
  else if(localStorage.getItem('viewCourse') == "false")
    this.getAllMentorshipsStudents()
}
  getAllCourseStudents() {
    this.viewCourses = true;
    let cid = this.courseService.getCurrentCourseId()
    console.log(cid);
    this.userService.getTrainerAllCourseStudent(cid).subscribe((res) => {
      console.log(res);
      this.courses = res;
    })
  }
  getAllMentorshipsStudents() {
    this.viewMentorships = true;
    let mid = this.mentorshipService.getCurrentMentorshipId()
    this.userService.getTrainerAllMentorshipStudent(mid).subscribe((res) => {
      console.log(res);
      this.mentorships = res;
    })
  }

}
