import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-create-mentorship',
  templateUrl: './create-mentorship.component.html',
  styleUrls: ['./create-mentorship.component.css']
})
export class CreateMentorshipComponent {
  mentorship={
    mentorshipName:'',
    mentorshipDescription:'',
    startDate:'',
    endDate:'',
    mentorshipCost:0,
    status:true
  }

  constructor(private userService: UserService) {
  }

  submit(){
    if(this.mentorship!= null)
      this.userService.createMentorship(this.mentorship).subscribe((data=>{
        console.log(data)
      }))
  }
}
