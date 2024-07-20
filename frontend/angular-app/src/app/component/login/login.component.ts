import { Component, OnInit } from '@angular/core';
import { UserService } from '../../service/user.service';
// import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Credentials } from '../../model/credentials';
import {HttpClient} from "@angular/common/http";
import {Router} from "@angular/router";

@Component({
  selector: 'login',
  templateUrl: 'login.component.html' })
export class LoginComponent implements OnInit {
  // loginForm: FormGroup = new FormGroup({
  //   email: new FormControl(),
  //   password: new FormControl()
  // });
  credentials: Credentials = new class implements Credentials {
    email: string = "";
    password: string = "";
  };

  constructor(
    private userService: UserService,
    private router: Router

    // private formBuilder: FormBuilder
  ) {}

  ngOnInit() {
    // console.log('init')
    // this.reactiveForm();
  }

  reactiveForm() {
    // this.loginForm = this.formBuilder.group({
    //   email: ['', [
    //     Validators.required,
    //     Validators.email
    //   ]],
    //   password: ['', [
    //     Validators.required
    //   ]]
    // });
    // console.log('reactiveForm')
  }

  errorHandling(control: string, error: string) {
    // return this.loginForm.controls[control].hasError(error);
  }

  login(): void {
    // console.log(this.loginForm.valid)
    console.log('login')
    // this.credentials.email = this.loginForm.value.email.trim();
    // this.credentials.password = this.loginForm.value.password.trim();
    this.userService.login(this.credentials)
      .subscribe(response => {
        console.log('success: '+response.success);
        console.log('message: '+response.message);
        if (response.success)
          this.router.navigate(['timesheet']);
      })
  }
}
