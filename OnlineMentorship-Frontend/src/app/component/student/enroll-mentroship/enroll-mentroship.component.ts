import {Component, OnInit} from '@angular/core';
import {Student} from "../../../model/Student";
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute, Router} from "@angular/router";
import {EnrollStudentService} from "../../../services/enroll-student.service";
import {CoursesService} from "../../../services/courses.service";
import {UserService} from "../../../services/user.service";
import {MentorshipsService} from "../../../services/mentorships.service";

@Component({
  selector: 'app-enroll-mentroship',
  templateUrl: './enroll-mentroship.component.html',
  styleUrls: ['./enroll-mentroship.component.css']
})
export class EnrollMentroshipComponent implements OnInit {
  paymentDetail={
    paymentAmount:0,
    isFullPaid:''
  }

  mentorship={
    mentorshipName:'',
    mentorshipCost:0,
  }
  student:Student= new Student();
  amountPaid=0;
  constructor(private snack :MatSnackBar, private router:Router,private route:ActivatedRoute,
              private enrollStudentService: EnrollStudentService, private mentorshipService: MentorshipsService,
              private userService:UserService){  }

  ngOnInit(): void {
    this.mentorship.mentorshipCost = this.mentorshipService.getCurrentMentorshipCost()
    this.mentorship.mentorshipName = this.mentorshipService.getCurrentMentorshipName()
    let s = this.userService.getCurrentStudent();
    if(s!=null)
      this.student =  JSON.parse(s);
  }
  fullPayment(){
    this.amountPaid = this.mentorship.mentorshipCost;
    this.paymentDetail.paymentAmount = this.amountPaid;
  }

  installment(){
    if(this.mentorship.mentorshipCost !== 0)
      this.amountPaid = this.mentorship.mentorshipCost/3;
    this.paymentDetail.paymentAmount = this.amountPaid;
  }

  enroll(){
    console.log("making payment")
    console.log(this.paymentDetail)
    this.enrollStudentService.enrollMentroship(this.paymentDetail).subscribe(
      (user:any)=>{
        console.log(user);
        alert("Payment Done!!")
        this.router.navigate(["student",{relativeTo:this.route}]);
      },
      (error) => {
        console.log('Error'+error.toString());
        this.snack.open("Payment Not Done",'',{
          duration:3000,
        })
      }
    );

  }

}
