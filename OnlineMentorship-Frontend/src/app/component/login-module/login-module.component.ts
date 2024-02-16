import { Component, OnInit } from '@angular/core';
import { MatSnackBar } from '@angular/material/snack-bar';
import {LoginService} from "../../services/login.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login-module',
  templateUrl: './login-module.component.html',
  styleUrls: ['./login-module.component.css']
})
export class LoginModuleComponent  implements OnInit{

  loginData = {
    email:'',
    password:'',
    usertype:''
  };
  ADMIN:string='ADMIN';
  STUDENT:string='STUDENT';
  TRAINER:string='TRAINER';

  constructor(private snack:MatSnackBar, private loginService: LoginService,private router:Router){  }

  ngOnInit(): void {

  }
  setUserType() {

  }

  login(){

    if(this.loginData.email.trim() == '' || this.loginData.email == null )
       {
        this.snack.open("Email is required!!",'',{
          duration:3000,
        });
        return;
       }
    if(this.loginData.password.trim() == '' || this.loginData.password == null )
    {
      this.snack.open("Password is required!!",'',{
        duration:3000,
      });
      return;
    }
    if(this.loginData.usertype.trim() == '' || this.loginData.usertype == null )
    {
      this.snack.open("UserType is required!!",'',{
        duration:3000,
      });
      return;
    }

    console.log(this.loginData);
    this.loginService.storeToken("")
    // this.loginService.login(this.loginData)

    this.loginService.login(this.loginData).subscribe(
      (data:any) => {
        console.log("Successful")
        console.log(data);

        this.loginService.storeToken(data.token);
        this.loginService.getCurrentUser().subscribe(
          user =>{
            console.log(user);
            this.loginService.setUser(user);
            console.log(user);
            // redirect to role -> admin, student, trainer

            if (this.loginService.getUserRole() == 'ADMIN') {
              this.router.navigate(['admin']);
              // this.loginService.loginStatusSubject.next(true);
            } else if (this.loginService.getUserRole() == 'STUDENT') {
              this.router.navigate(['student']);
              //
              // this.loginService.loginStatusSubject.next(true);
            }else if(this.loginService.getUserRole() == 'TRAINER'){
              this.router.navigate(['trainer']);
            }
            else {
              this.loginService.logout();
              //location.reload();
            }

          }
        );

      },
      (error) => {
        console.log('Error'+error.toString());
        this.snack.open("Invalid Details!! Try again",'',{
          duration:3000,
        })
      }
    );
  }




}
