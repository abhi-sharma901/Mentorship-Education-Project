import { Component } from '@angular/core';
import {MentorshipsService} from "../../services/mentorships.service";
import {LoginService} from "../../services/login.service";
import {ActivatedRoute, Router} from "@angular/router";

@Component({
  selector: 'app-mentorship',
  templateUrl: './mentorship.component.html',
  styleUrls: ['./mentorship.component.css']
})
export class MentorshipComponent {

  Mentorships: any = [];
  user:any;
  isLoggedIn: any;
  mentorshipId:any;
  constructor(private service: MentorshipsService,private route:ActivatedRoute, private loginService:LoginService, private router:Router) { }
  //to invoke things we use ngOnInit
  ngOnInit() {
    this.getAllMentorships();
    this.isLoggedIn = this.loginService.isLoggedIn()
    this.user = this.loginService.getUser();
  }
  getAllMentorships() {
    this.service.getAllMentorships().subscribe((res) => {
      console.log(res);
      this.Mentorships = res;
    })
  }
  setCurrentCourseId(mentorship:any){
    this.service.setCurrentMentorship(mentorship);
    this.router.navigate(["enrollMentorship",{relativeTo:this.route}]);

  }

}
