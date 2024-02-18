import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-view-students',
  templateUrl: './view-students.component.html',
  styleUrls: ['./view-students.component.css']
})
export class ViewStudentsComponent {
students: any=[]

  constructor(private userService:UserService,) { }

  ngOnInit(){
  this.viewStudents()
  }
  viewStudents()
  {
    this.userService.viewAllStudents().subscribe((data)=>{
      console.log(data)
      this.students=data
    })
  }
}
