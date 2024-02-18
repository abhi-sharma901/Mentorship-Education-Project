import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {User} from "../model/User";
import {LoginService} from "./login.service";
import {Observable} from "rxjs";

const  baseUrl = 'http://localhost:8091/onlineMentorship';
@Injectable({
  providedIn: 'root'
})


export class UserService {

  user:User = new User();
  constructor(private http:HttpClient, private loginService:LoginService) { }

  public setStudent(){
    let email = this.loginService.getUser().username;
    this.http.get(`${baseUrl}/student/showStudent/`+email).subscribe(
      (user:any)=>{
        console.log(user);
        this.user.userId = user.studentId;
        this.user.firstName = user.firstName;
        this.user.lastName = user.lastName;
        this.user.email = user.email;
        this.user.contactNumber = user.contactNumber;
        this.user.password = user.password
        console.log(this.user);
        localStorage.setItem("currentUser",JSON.stringify(this.user));
    }
    );
  }

  public setTrainer(){
    let email = this.loginService.getUser().username;
    this.http.get(`${baseUrl}/trainer/showTrainer/`+email).subscribe(
      (user:any)=>{
        console.log(user);
        this.user.userId = user.trainerId;
        this.user.firstName = user.firstName;
        this.user.lastName = user.lastName;
        this.user.email = user.email;
        this.user.contactNumber = user.contactNumber;
        this.user.password = user.password
        localStorage.setItem("currentUser",JSON.stringify(this.user));
      }
    );
  }

  getAllPayments(): Observable<any> {
    return this.http.get(baseUrl + "/viewPayments");
  }


  public changePassword(){
   return this.http.put(`${baseUrl}/updateStudentPassword`, this.getCurrentUser());

  }

  public getCurrentUser(){

    return localStorage.getItem("currentUser");
  }

  public getUserId(){
    let s =localStorage.getItem("currentUser");
    if(s!= null) {
      let user = JSON.parse(s);
      return user.userId;
    }
    return null;
  }

}
