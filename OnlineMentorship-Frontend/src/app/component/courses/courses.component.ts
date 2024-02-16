import { Component } from '@angular/core';
import {CoursesService} from "../../services/courses.service";

@Component({
  selector: 'app-courses',
  templateUrl: './courses.component.html',
  styleUrls: ['./courses.component.css']
})
export class CoursesComponent {
  courses: any = [];
  constructor(private service: CoursesService) { }
  ngOnInit() {
    this.getAllCourses();
  }
  getAllCourses() {
    this.service.getAllCustomers().subscribe((res) => {
      console.log(res);
      this.courses = res;
    })
  }
}
