import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {LoginModuleComponent} from "./component/login-module/login-module.component";
import {HomeComponent} from "./component/home/home.component";
import {RegisterComponent} from "./component/register/register.component";
import {AdminDashboardComponent} from "./component/admin/admin-dashboard/admin-dashboard.component";
import {StudentDashboardComponent} from "./component/student/student-dashboard/student-dashboard.component";
import {AdminGuard} from "./services/admin.guard";
import {StudentGuard} from "./services/student.guard";
import {TrainerDashboardComponent} from "./component/trainer/trainer-dashboard/trainer-dashboard.component";
import {TrainerGuard} from "./services/trainer.guard";
import {CoursesComponent} from "./component/courses/courses.component";
import {MentorshipComponent} from "./component/mentorship/mentorship.component";
import {EnrollCourseComponent} from "./component/student/enroll-course/enroll-course.component";
import {StudentProfileComponent} from "./component/student/student-profile/student-profile.component";
import {EnrollMentroshipComponent} from "./component/student/enroll-mentroship/enroll-mentroship.component";
import {StudentPaymentsComponent} from "./component/student/student-payments/student-payments.component";
import {StudentEnrollmentsComponent} from "./component/student/student-enrollments/student-enrollments.component";
import {TrainerProfileComponent} from "./component/trainer/trainer-profile/trainer-profile.component";
import {TrainerEnrollmentsComponent} from "./component/trainer/trainer-enrollments/trainer-enrollments.component";
import {TrainerViewStudentComponent} from "./component/trainer/trainer-view-student/trainer-view-student.component";
import {AdminAssignCourseComponent} from "./component/admin/admin-assign-course/admin-assign-course.component";
import {
  AdminAssignMentorshipComponent
} from "./component/admin/admin-assign-mentorship/admin-assign-mentorship.component";
import {ViewStudentsComponent} from "./component/admin/view-students/view-students.component";
import {ViewTrainersComponent} from "./component/admin/view-trainers/view-trainers.component";
import {CreateCourseComponent} from "./component/admin/create-course/create-course.component";
import {CreateMentorshipComponent} from "./component/admin/create-mentorship/create-mentorship.component";

// const studentRoutes = () => import ('../component/student/student-dashboard/student-dashboard.module').then(m=>m.StudentDashboardModule);


const routes:Routes =[
  {path:'', pathMatch:'full',component:HomeComponent},
  {path:'register',component:RegisterComponent,pathMatch:'full'},
  {path:'login',component:LoginModuleComponent,},
  {path:'courses', component:CoursesComponent,
  children:[
    {path:'enrollCourse', component:EnrollCourseComponent,}
  ]
  },
  {path:'mentorship',component:MentorshipComponent, pathMatch:'full',},
  {path:'admin', component:AdminDashboardComponent, pathMatch:'full', canActivate:[AdminGuard],},
  {path:'adminAssignCourse', component:AdminAssignCourseComponent, canActivate:[AdminGuard]},
  {path:'adminAssignMentorships', component:AdminAssignMentorshipComponent, canActivate:[AdminGuard]},
  {path:'student', component:StudentDashboardComponent, canActivate:[StudentGuard],
    children:[
      // {path:'enrollCourse', component:EnrollCourseComponent,},
      {path:'studentProfile', component:StudentProfileComponent,}]
  },
  {path:'trainer', component:TrainerDashboardComponent, pathMatch:'full', canActivate:[TrainerGuard]
  },
  {path:'studentProfile', component:StudentProfileComponent,},
{ path:'enrollCourse', component:EnrollCourseComponent, canActivate:[StudentGuard]}
  ,{path:'enrollMentorship', component:EnrollMentroshipComponent, canActivate:[StudentGuard]}
  ,{path:'studentPayments', component:StudentPaymentsComponent, canActivate:[StudentGuard]}
  ,{path:'studentEnrollments', component:StudentEnrollmentsComponent, canActivate:[StudentGuard]}
  ,{path:'trainerProfile', component:TrainerProfileComponent, canActivate:[TrainerGuard]}
  ,{path:'trainerEnrollments', component:TrainerEnrollmentsComponent, canActivate:[TrainerGuard]}
  ,{path:'trainerViewStudents', component:TrainerViewStudentComponent, canActivate:[TrainerGuard]}
  ,{path:'adminViewStudents', component:ViewStudentsComponent, canActivate:[AdminGuard]}
  ,{path:'adminViewTrainers', component:ViewTrainersComponent, canActivate:[AdminGuard]}
  ,{path:'adminCreateCourse', component:CreateCourseComponent, canActivate:[AdminGuard]}
  ,{path:'adminCreateMentorship', component:CreateMentorshipComponent, canActivate:[AdminGuard]}

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
export class AppRoutingModule {}
