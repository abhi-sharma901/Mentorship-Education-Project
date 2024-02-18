import {Component, OnInit} from '@angular/core';
import {MatSnackBar} from "@angular/material/snack-bar";
import {ActivatedRoute, Router, Routes} from "@angular/router";
import {EnrollStudentService} from "../../../services/enroll-student.service";
import {CoursesService} from "../../../services/courses.service";
import {User} from "../../../model/User";
import {UserService} from "../../../services/user.service";

@Component({
  selector: 'app-enroll-course',
  templateUrl: './enroll-course.component.html',
  styleUrls: ['./enroll-course.component.css']
})
export class EnrollCourseComponent implements OnInit{

  paymentDetail={
    paymentAmount:0,
    isFullPaid:''
  }

  course={
    courseName:'',
    courseCost:0,
  }
  student:User= new User();
  amountPaid=0;
  constructor(private snack :MatSnackBar, private router:Router,private route:ActivatedRoute,
              private enrollStudentService: EnrollStudentService, private courseService: CoursesService,
              private userService:UserService){  }

  ngOnInit(): void {
    this.course.courseCost = this.courseService.getCurrentCourseCost()
    this.course.courseName = this.courseService.getCurrentCourseName()
    let s = this.userService.getCurrentUser();
    if(s!=null)
      this.student =  JSON.parse(s);
  }
  fullPayment(){
    this.amountPaid = this.course.courseCost;
    this.paymentDetail.paymentAmount = this.amountPaid;
  }

  installment(){
    if(this.course.courseCost !== 0)
    this.amountPaid = this.course.courseCost/3;
    this.paymentDetail.paymentAmount = this.amountPaid;
  }

  enroll(){
    console.log("making payment")
    console.log(this.paymentDetail)
    this.enrollStudentService.enrollCourse(this.paymentDetail).subscribe(
      (user:any)=>{
        console.log(user);
        alert("Payment Done Successfully!!")
        this.router.navigate(["student",{relativeTo:this.route}]);
      },
      (error) => {
        console.log('Error'+error.toString());
        this.snack.open("Payment Not Processed. Please try again!!",'',{
          duration:3000,
        })
      }
    );
  }

}
