import { Injectable } from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Student} from "../model/Student";
import {LoginService} from "./login.service";

const  baseUrl = 'http://localhost:8091/onlineMentorship/student';
@Injectable({
  providedIn: 'root'
})


export class UserService {

  student:Student = new Student();
  constructor(private http:HttpClient, private loginService:LoginService) { }

  public setStudent(){
    let email = this.loginService.getUser().username;
    this.http.get(`${baseUrl}/showStudent/`+email).subscribe(
      (user:any)=>{
        console.log(user);
        this.student.studentId = user.studentId;
        this.student.firstName = user.firstName;
        this.student.lastName = user.lastName;
        this.student.email = user.email;
        this.student.contactNumber = user.contactNumber;
        this.student.password = user.password
        console.log(this.student);
        localStorage.setItem("currentUser",JSON.stringify(this.student));
    }
    );
  }

  public changePassword(){
   return this.http.put(`${baseUrl}/updateStudentPassword`, this.getCurrentStudent());

  }

  public getCurrentStudent(){

    return localStorage.getItem("currentUser");
  }

  public getStudentId(){
    let s =localStorage.getItem("currentUser");
    if(s!= null) {
      let student = JSON.parse(s);
      return student.studentId;
    }
    return null;
  }

}
