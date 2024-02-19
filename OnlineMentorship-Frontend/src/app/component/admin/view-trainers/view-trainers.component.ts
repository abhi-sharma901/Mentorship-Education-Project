import { Component } from '@angular/core';
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-view-trainers',
  templateUrl: './view-trainers.component.html',
  styleUrls: ['./view-trainers.component.css']
})
export class ViewTrainersComponent {

  trainers: any=[]

  constructor(private userService:UserService,) { }

  ngOnInit(){
    this.viewTrainers()
  }
  viewTrainers()
  {
    this.userService.viewAllTrainers().subscribe((data)=>{
      console.log(data)
      this.trainers = data;
    })
  }
}
