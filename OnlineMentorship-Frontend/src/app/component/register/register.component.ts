import { Component } from '@angular/core';
import {UserData} from "../../model/UserData";
import {RegisterService} from "../../services/register.service";
import {MatSnackBar} from "@angular/material/snack-bar";
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";
import {UserService} from "../../services/user.service";

@Component({
  selector: 'app-student-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  userData:UserData = new UserData();

  ngOnInit(): void {

  }
  ADMIN:string='ADMIN';
  STUDENT:string='STUDENT';
  TRAINER:string='TRAINER';
  constructor(private snack:MatSnackBar, private registerService :RegisterService,private  loginService:LoginService,private router:Router, private userervice:UserService){}
  onSubmit() {

    if (this.userData.email.trim() == '' || this.userData.email == null) {
      this.snack.open("Email is required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.userData.password.trim() == '' || this.userData.password == null) {
      this.snack.open("Password is required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.userData.firstName.trim() == '' || this.userData.firstName == null) {
      this.snack.open("UserType is required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.userData.lastName.trim() == '' || this.userData.lastName == null) {
      this.snack.open("UserType is required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.userData.contactNumber.trim() == '' || this.userData.contactNumber == null) {
      this.snack.open("UserType is required!!", '', {
        duration: 3000,
      });
      return;
    }
    if (this.userData.usertype.trim() == '' || this.userData.usertype == null) {
      this.snack.open("UserType is required!!", '', {
        duration: 3000,
      });
      return;
    }
    console.log(this.userData);
    this.loginService.storeToken('');

    this.registerService.register(this.userData).subscribe((data:any) => {
      console.log("Succesfull registeration")
      console.log(data);
      alert("Succesfull registeration!! Please login to use the site.")
      this.router.navigate(["/login"])

    }, (error) => {
      console.log('Error'+error.toString());
      this.snack.open("Invalid Details!! Try again",'',{
        duration:3000,
      })
    })
  }

}
