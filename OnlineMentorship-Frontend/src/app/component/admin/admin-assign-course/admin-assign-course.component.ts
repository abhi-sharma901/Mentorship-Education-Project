import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-assign-course',
  templateUrl: './admin-assign-course.component.html',
  styleUrls: ['./admin-assign-course.component.css']
})
export class AdminAssignCourseComponent {
  trainerId:number=0;
  courseId:number=0;

  constructor(private userService:UserService, private router: Router) {
  }
  submit(){
    console.log(this.trainerId)
    this.userService.assignCourse(this.trainerId,this.courseId).subscribe((data:any)=>
    {
      console.log(data);
      this.router.navigate(["/admin"])
    })
  }


}
