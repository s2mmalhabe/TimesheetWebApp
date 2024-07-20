import { Component } from '@angular/core';
import { UserService } from '../../service/user.service';
import { Credentials } from '../../model/credentials';
import {Router} from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: 'login.component.html' })
export class LoginComponent {
  credentials: Credentials = new class implements Credentials {
    email: string = "";
    password: string = "";
  };

  constructor(
    private userService: UserService,
    private router: Router
  ) {}

  login(): void {
    this.userService.login(this.credentials)
      .subscribe(response => {
        console.log('success: '+response.success);
        console.log('message: '+response.message);
        if (response.success)
          this.router.navigate(['timesheet']);
      });
  }
}
