import { BreakpointObserver } from '@angular/cdk/layout';
import { AfterViewInit, Component, OnInit, ViewChild } from '@angular/core';

import { LoginService } from './../../services/login.service';

import { Router } from '@angular/router';

import { MatSidenav } from '@angular/material/sidenav';
import { delay } from 'rxjs/operators';
@Component({
  selector: 'app-navbar',
  templateUrl: './navbar.component.html',
  styleUrls: ['./navbar.component.css'],
})
export class NavbarComponent implements OnInit {
  @ViewChild(MatSidenav)
  sidenav!: MatSidenav;
  isLoggedIn = false;
  userRole: any;
  constructor(
    public loginService: LoginService,
    private router: Router
  ) {}

  ngOnInit(): void {
    this.isLoggedIn = this.loginService.isLoggedIn();
    this.userRole = this.loginService.getUserRole();
  }
  goToDashboard(){
    if (this.loginService.getUserRole() == 'ADMIN') {
      this.router.navigate(['admin']);
    } else if (this.loginService.getUserRole() == 'STUDENT') {
      this.router.navigate(['student']);

    }else if(this.loginService.getUserRole() == 'TRAINER'){
      this.router.navigate(['trainer']);
    }
    else {
      this.logout();
    }
  }

  public logout() {
    this.loginService.logout();
    this.isLoggedIn= false;
    this.router.navigate(['login']);
  }
}
