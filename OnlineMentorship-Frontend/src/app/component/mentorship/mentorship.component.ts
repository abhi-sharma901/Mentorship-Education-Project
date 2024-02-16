import { Component } from '@angular/core';
import {MentorshipsService} from "../../services/mentorships.service";

@Component({
  selector: 'app-mentorship',
  templateUrl: './mentorship.component.html',
  styleUrls: ['./mentorship.component.css']
})
export class MentorshipComponent {

  Mentorships: any = [];
  constructor(private service: MentorshipsService) { }
  //to invoke things we use ngOnInit
  ngOnInit() {
    this.getAllMentorships();
  }
  getAllMentorships() {
    this.service.getAllMentorships().subscribe((res) => {
      console.log(res);
      this.Mentorships = res;
    })
  }

}
