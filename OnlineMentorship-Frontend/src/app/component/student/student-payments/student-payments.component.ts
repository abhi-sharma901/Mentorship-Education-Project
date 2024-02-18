import { Component } from '@angular/core';
import {CoursesService} from "../../../services/courses.service";
import {LoginService} from "../../../services/login.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-student-payments',
  templateUrl: './student-payments.component.html',
  styleUrls: ['./student-payments.component.css']
})
export class StudentPaymentsComponent {
  payments: any = [];
  user:any;
  isLoggedIn: any;

  constructor(private courseService: CoursesService, private loginService:LoginService, private route:ActivatedRoute, private router:Router) { }
  ngOnInit() {
    this.getAllCourses();
    this.isLoggedIn = this.loginService.isLoggedIn()
    this.user = this.loginService.getUser();

  }
  getAllCourses() {
    this.courseService.getAllCourses().subscribe((res) => {
      console.log(res);
      this.payments = res;
    })
  }

  setCurrentCourseId(course:any){
    this.courseService.setCurrentCourse(course);
    this.router.navigate(["enrollCourse",{relativeTo:this.route}]);

  }

}
