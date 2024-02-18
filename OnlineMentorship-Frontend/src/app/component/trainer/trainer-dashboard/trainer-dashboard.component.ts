import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";
import {ActivatedRoute, Router} from "@angular/router";
import {User} from "../../../model/User";

@Component({
  selector: 'app-trainer-dashboard',
  templateUrl: './trainer-dashboard.component.html',
  styleUrls: ['./trainer-dashboard.component.css']
})
export class TrainerDashboardComponent {
  constructor(private userService: UserService){}
  trainer:User = new User();
  ngOnInit(){

    let s = this.userService.getCurrentUser();
    if(s!=null)
      this.trainer =  JSON.parse(s);
  }
}
