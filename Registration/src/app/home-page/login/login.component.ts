import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{

  user= new User("","");

  constructor() { }

  userLogin(){
    console.log(this.user);
  }

  loginForm=new FormGroup({
    emailId:new FormControl('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),Validators.maxLength(50)]),
   password:new FormControl('',[Validators.required, Validators.maxLength(15)])
  });

  get emailId(){
    return this.loginForm.get('emailId')
  }

  get password(){
    return this.loginForm.get('password')
  }

}
