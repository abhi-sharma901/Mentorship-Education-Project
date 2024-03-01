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

  public assignCourse(tid:number,cid:number){
    return this.http.post(`${baseUrl}/admin/assignCourse/${tid}/${cid}`,null);
  }

  public assignMentorship(tid:number,mid:number){
    return this.http.post(`${baseUrl}/admin/assignMentorship/${tid}/${mid}`,null);
  }

  public viewAllStudents(){
    return this.http.get(`${baseUrl}/admin/viewAllStudents`,);
  }

  public viewAllTrainers(){
    return this.http.get(`${baseUrl}/admin/viewAllTrainers`,);
  }

  public createCourse(course:any){
    return this.http.post(`${baseUrl}/admin/createCourse`,course);

  }

  public createMentorship(mentorship:any){
    return this.http.post(`${baseUrl}/admin/createMentorship`,mentorship);

  }



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

  public getStudentAllCourses(){
    let sid = this.getUserId();
    return this.http.get(`${baseUrl}/student/${sid}/myCourses`);
  }

  getStudentAllMentorships(){
    let sid = this.getUserId();
    return this.http.get(`${baseUrl}/student/${sid}/myMentorships`);
  }

  public getTrainerAllCourses(){
    let tid = this.getUserId();
    return this.http.get(`${baseUrl}/trainer/${tid}/assignedCourses`);
  }

  public getTrainerAllCourseStudent(cid:any){
    // let tid = this.getUserId();
    return this.http.get(`${baseUrl}/trainer/${cid}/students`);
  }

  public getTrainerAllMentorshipStudent(mid:any){
    // let tid = this.getUserId();
    return this.http.get(`${baseUrl}/trainer/${mid}/student`);
  }

  public getTrainerAllMentorships(){
    let tid = this.getUserId();
    return this.http.get(`${baseUrl}/trainer/${tid}/assignedMentorships`);
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

  getAllMyPayments(): Observable<any> {
    let sid = this.getUserId();
    return this.http.get(`${baseUrl}/student/${sid}/myPayments`);
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
