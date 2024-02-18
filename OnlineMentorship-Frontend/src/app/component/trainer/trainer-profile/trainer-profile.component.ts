import { Component } from '@angular/core';
import {User} from "../../../model/User";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-trainer-profile',
  templateUrl: './trainer-profile.component.html',
  styleUrls: ['./trainer-profile.component.css']
})
export class TrainerProfileComponent {

  trainer:User=new User();
  updatePassword=false
  newPass=''
  ngOnInit(){
    let s = this.userService.getCurrentUser();
    if(s!=null)
      this.trainer =  JSON.parse(s);  }
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
