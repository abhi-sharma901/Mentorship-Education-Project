import { Component } from '@angular/core';
import {CoursesService} from "../../services/courses.service";
import {LoginService} from "../../services/login.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  courses: any = [];
  user:any;
  isLoggedIn: any;

  constructor(private service: CoursesService, private loginService:LoginService) { }
  ngOnInit() {
    this.getAllCourses();
    this.isLoggedIn = this.loginService.isLoggedIn()
    this.user = this.loginService.getUser();

  }
  getAllCourses() {
    this.service.getAllCustomers().subscribe((res) => {
      console.log(res);
      this.courses = res;
    })
  }
}
