import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-create-course',
  templateUrl: './create-course.component.html',
  styleUrls: ['./create-course.component.css']
})
export class CreateCourseComponent {

  course={
    courseName:'',
    courseDescription:'',
    startDate:'',
    endDate:'',
    courseCost:0
  }

  constructor(private userService: UserService) {
  }

  submit(){
    if(this.course!= null)
    this.userService.createCourse(this.course).subscribe((data=>{
      console.log(data)
    }))
  }
}
