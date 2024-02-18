import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Student} from "../../../model/Student";

@Component({
  selector: 'app-student-profile',
  templateUrl: './student-profile.component.html',
  styleUrls: ['./student-profile.component.css']
})
export class StudentProfileComponent {

  student:Student=new Student();
  updatePassword=false
  newPass=''
  ngOnInit(){
    let s = this.userService.getCurrentStudent();
    if(s!=null)
      this.student =  JSON.parse(s);  }
  constructor(private userService:UserService) {}
  changePassword(){
   // this.updatePassword=true,
    console.log(this.updatePassword)
    this.userService.changePassword().subscribe((data:any)=>{
      console.log("successfull" +data)
      this.updatePassword = false
    })
  }
  updatePass(){
    this.updatePassword=true;
  }

}
