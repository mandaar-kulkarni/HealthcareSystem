import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  constructor() { }
  loginForm=new FormGroup({
    email: new FormControl('',Validators.required),
    password : new FormControl('',Validators.required)
  });

  collectData(){
    console.warn(this.loginForm.value);
  }

  get email(){return this.loginForm.get('email')}

  get password(){return this.loginForm.get('password')}

}
