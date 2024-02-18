import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {CoursesService} from "../../../services/courses.service";

@Component({
  selector: 'app-trainer-enrollments',
  templateUrl: './trainer-enrollments.component.html',
  styleUrls: ['./trainer-enrollments.component.css']
})
export class TrainerEnrollmentsComponent {
  courses: any = [];
  mentorships:any =[]
  viewCourses = false;
  viewMentorships = false;
  constructor(private userService:UserService, private route:ActivatedRoute, private router:Router,private courseService:CoursesService) { }

  getAllMyCourses() {
    this.viewCourses=true;
    this.viewMentorships=false;
    this.userService.getTrainerAllCourses().subscribe((res) => {
      console.log(res);
      this.courses = res;
    })
  }
  getCurrentCourseId(course:any){
    this.viewMentorships = false;
    this.viewCourses = false;
    console.log(course)
    this.courseService.setCurrentCourse(course);
    localStorage.setItem('viewCourse',"true");
    this.router.navigate(["trainerViewStudents",{relativeTo:this.route}]);
  }

  getAllMyMentorships() {
    this.viewMentorships = true;
    this.viewCourses = false;
    this.userService.getTrainerAllMentorships().subscribe((res) => {
      console.log(res);
      this.mentorships = res;
    })
  }

}
