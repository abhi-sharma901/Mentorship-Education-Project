import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-admin-assign-mentorship',
  templateUrl: './admin-assign-mentorship.component.html',
  styleUrls: ['./admin-assign-mentorship.component.css']
})
export class AdminAssignMentorshipComponent {

  trainerId:number=0;
  mentorshipId:number=0;

  constructor(private userService:UserService, private router: Router) {
  }
  submit(){
    this.userService.assignMentorship(this.trainerId,this.mentorshipId).subscribe((data:any)=>
    {
      console.log(data);
      this.router.navigate(["/admin"])
    })
  }
}
