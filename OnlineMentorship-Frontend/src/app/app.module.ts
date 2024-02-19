import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { LoginModuleComponent } from './component/login-module/login-module.component';
import { FormsModule } from '@angular/forms';
import {MatSnackBarModule} from '@angular/material/snack-bar';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {HttpClientModule} from "@angular/common/http";
import {authInterceptorProvider} from "./services/auth.interceptor";
import { RegisterComponent } from './component/register/register.component';
import { AdminDashboardComponent } from './component/admin/admin-dashboard/admin-dashboard.component';
import { StudentDashboardComponent } from './component/student/student-dashboard/student-dashboard.component';
import {AppRoutingModule} from "./app-routing.module";
import {HomeComponent} from "./component/home/home.component";
import {RouterOutlet} from "@angular/router";
import { TrainerDashboardComponent } from './component/trainer/trainer-dashboard/trainer-dashboard.component';
import { NavbarComponent } from './component/navbar/navbar.component';
import {MatToolbar, MatToolbarModule} from "@angular/material/toolbar";
import {MatProgressSpinnerModule} from "@angular/material/progress-spinner";
import {MatSidenavModule} from "@angular/material/sidenav";
import {MatSelectModule} from "@angular/material/select";
import {MatSlideToggleModule} from "@angular/material/slide-toggle";
import {MatDividerModule} from "@angular/material/divider";
import {MatGridListModule} from "@angular/material/grid-list";
import {MatListModule} from "@angular/material/list";
import {MatCardModule} from "@angular/material/card";
import {MatIconModule} from "@angular/material/icon";
import { CoursesComponent } from './component/courses/courses.component';
import { MentorshipComponent } from './component/mentorship/mentorship.component';
import { EnrollCourseComponent } from './component/student/enroll-course/enroll-course.component';
import { StudentProfileComponent } from './component/student/student-profile/student-profile.component';
import { EnrollMentroshipComponent } from './component/student/enroll-mentroship/enroll-mentroship.component';
import { StudentPaymentsComponent } from './component/student/student-payments/student-payments.component';
import { StudentEnrollmentsComponent } from './component/student/student-enrollments/student-enrollments.component';
import { TrainerProfileComponent } from './component/trainer/trainer-profile/trainer-profile.component';
import { TrainerEnrollmentsComponent } from './component/trainer/trainer-enrollments/trainer-enrollments.component';
import { TrainerViewStudentComponent } from './component/trainer/trainer-view-student/trainer-view-student.component';
import { AdminAssignCourseComponent } from './component/admin/admin-assign-course/admin-assign-course.component';
import { AdminAssignMentorshipComponent } from './component/admin/admin-assign-mentorship/admin-assign-mentorship.component';

import { SidebarComponent } from './component/sidebar/sidebar.component';


import { ViewStudentsComponent } from './component/admin/view-students/view-students.component';
import { ViewTrainersComponent } from './component/admin/view-trainers/view-trainers.component';
import { CreateCourseComponent } from './component/admin/create-course/create-course.component';
import { CreateMentorshipComponent } from './component/admin/create-mentorship/create-mentorship.component';


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginModuleComponent,
    RegisterComponent,
    AdminDashboardComponent,
    StudentDashboardComponent,
    TrainerDashboardComponent,
    NavbarComponent,
    CoursesComponent,
    MentorshipComponent,
    EnrollCourseComponent,
    StudentProfileComponent,
    EnrollMentroshipComponent,
    StudentPaymentsComponent,
    StudentEnrollmentsComponent,
    TrainerProfileComponent,
    TrainerEnrollmentsComponent,
    TrainerViewStudentComponent,
    AdminAssignCourseComponent,
    AdminAssignMentorshipComponent,

    SidebarComponent,
    ViewStudentsComponent,
    ViewTrainersComponent,
    CreateCourseComponent,
    CreateMentorshipComponent,

  ],
  imports: [
    BrowserModule,
    FormsModule,
    // StudentDashboardModule,
    HttpClientModule,
    AppRoutingModule,
    MatSnackBarModule,
    BrowserAnimationsModule,
    RouterOutlet,
    MatSnackBarModule,
    MatToolbarModule,
    MatIconModule,
    MatCardModule,
    MatListModule,
    MatGridListModule,
    MatDividerModule,
    MatSlideToggleModule,
    MatSelectModule,
    MatSidenavModule,
    MatProgressSpinnerModule,
  ],
  providers: [ authInterceptorProvider,],
  bootstrap: [AppComponent]
})
export class AppModule { }
