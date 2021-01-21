import { Patient } from './../../patient';
import { Router } from '@angular/router';
import { AuthenticateService } from './../../authenticate.service';
import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/user';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent{
  user=new User("","");
  message:string="";
  constructor(private service:AuthenticateService,private router:Router) { }

  userLogin(){
    console.log(this.user);
    this.service.authenticateUser(this.user).subscribe((response)=>{
      console.log(response);
      if(response.role=="ADMIN"){
        this.router.navigate(['listofdoctor']);
      }else if(response.role=="PATIENT"){
        sessionStorage.setItem("patient",JSON.stringify(response.patient));
        this.router.navigate(['appointmentlist']);
      }else if(response.role=="DOCTOR"){
        this.router.navigate(['listofappointment']);
      }
    },(error)=>{
      console.log(error);
      this.message=error.error.message;
    });
  }
}
