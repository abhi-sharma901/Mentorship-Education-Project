import {Component, NgModule} from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Student} from "../../../model/Student";
import {ActivatedRoute, Router} from "@angular/router";


@Component({
  selector: 'app-student-dashboard',
  templateUrl: './student-dashboard.component.html',
  styleUrls: ['./student-dashboard.component.css']
})
export class StudentDashboardComponent {
  constructor(private userService: UserService,private router:Router, private route:ActivatedRoute){}
  student:Student = new Student();
  ngOnInit(){
    let s = this.userService.getCurrentStudent();
    if(s!=null)
      this.student =  JSON.parse(s);
  }



}
