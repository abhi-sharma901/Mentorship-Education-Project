import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginModuleComponent} from "../../component/login-module/login-module.component";
import {HomeComponent} from "../../component/home/home.component";
import {RegisterComponent} from "../../component/register/register.component";
import {AdminDashboardComponent} from "../../component/admin/admin-dashboard/admin-dashboard.component";
import {StudentDashboardComponent} from "../../component/student/student-dashboard/student-dashboard.component";
import {AdminGuard} from "../../services/admin.guard";
import {StudentGuard, studentGuard} from "../../services/student.guard";
import {TrainerDashboardComponent} from "../../component/trainer/trainer-dashboard/trainer-dashboard.component";
import {TrainerGuard} from "../../services/trainer.guard";
import {CoursesComponent} from "../../component/courses/courses.component";
import {MentorshipComponent} from "../../component/mentorship/mentorship.component";
import {EnrollCourseComponent} from "../../component/student/enroll-course/enroll-course.component";


const routes:Routes =[
  {path:'', pathMatch:'full',component:HomeComponent},
  {path:'register',component:RegisterComponent,pathMatch:'full'},
  {path:'login',component:LoginModuleComponent,pathMatch:'full'},
  {
    path:'courses',
    component:CoursesComponent,
    pathMatch:'full',
  },
  {
    path:'mentorship',
    component:MentorshipComponent,
    pathMatch:'full',
  },

  {
    path:'admin',
    component:AdminDashboardComponent,
    pathMatch:'full',
    canActivate:[
      AdminGuard
    ],
  },
  {
    path:'student',
    component:StudentDashboardComponent,
    pathMatch:'full',
    canActivate:[
      StudentGuard
    ],
    children:[
      {
        path:'enrollCourse',
        component:EnrollCourseComponent,
        pathMatch:'full',
      }
    ]
  },
  {
    path:'trainer',
    component:TrainerDashboardComponent,
    pathMatch:'full',
    canActivate:[
      TrainerGuard
    ]
  },





]
@NgModule({
  declarations: [],
  imports: [
    CommonModule,
    RouterModule.forRoot(routes)
  ],
  exports:[
    RouterModule
  ]
})
export class AppRoutingModule {


}
