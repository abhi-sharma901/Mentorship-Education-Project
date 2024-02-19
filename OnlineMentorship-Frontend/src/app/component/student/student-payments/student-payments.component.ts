import { Component } from '@angular/core';
import {CoursesService} from "../../../services/courses.service";
import {LoginService} from "../../../services/login.service";
import {ActivatedRoute, Router} from "@angular/router";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-student-payments',
  templateUrl: './student-payments.component.html',
  styleUrls: ['./student-payments.component.css']
})
export class StudentPaymentsComponent {
  payments: any = [];
  user:any;
  isLoggedIn: any;

  constructor(private userService : UserService, private loginService:LoginService, private route:ActivatedRoute, private router:Router) { }
  ngOnInit() {
    this.getAllMyPayments();
    this.isLoggedIn = this.loginService.isLoggedIn()
    this.user = this.loginService.getUser();
  }
  getAllMyPayments() {
    this.userService.getAllMyPayments().subscribe((res) => {
      console.log(res);
      this.payments = res;
    })
  }

}
