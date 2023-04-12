import { Component, OnInit } from '@angular/core';

import { NgForm } from '@angular/forms';

import { LoginServiceService } from './LoginService/login-service.service';
import { MainServiceService } from 'src/app/main-service.service';

@Component({
  selector: 'app-login-page',
  templateUrl: './login-page.component.html',
  styleUrls: ['./login-page.component.css']
})
export class LoginPageComponent implements OnInit {

  constructor(private loginService: LoginServiceService, private mainService: MainServiceService) { }

  loginError: string= ""
  JwtToken: string= ""
  loginOrNot: boolean= false

  ngOnInit(): void {
  }

  loginForm(formData: NgForm): void {

    this.loginService.loginFormData(formData.value).subscribe((loginDetail: string) => {

      if(loginDetail.match("Not valid username or password")) {

        this.loginError= loginDetail
      }
      else {

        this.loginError= ""
        this.JwtToken= loginDetail
        this.loginOrNot= true
        sessionStorage.setItem("Token", `Bearer ${this.JwtToken}`)
      }
      this.mainService.loginInformation.emit(this.loginOrNot)
    })

    formData.reset()
  }

}
