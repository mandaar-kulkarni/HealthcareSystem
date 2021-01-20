import { Router } from '@angular/router';
import { AuthenticateService } from './../../authenticate.service';
import { User } from '../../user';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../../patient';
import { Trail } from 'src/app/dto/Trail';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent {
  patient=new Patient("","","","","","","");
  user=new User("","","PATIENT");
  confirmPassword:string="";
  password:string="";
  message:string="";

  constructor(private service:AuthenticateService,private router:Router) { }

  ngOnInit(): void {
  }

  registerPatient(){
    this.user.emailId=this.patient.emailId;
    console.log(this.patient);
    console.log(this.user);
    this.service.registerPatient(new Trail(this.patient,this.user))
    .subscribe(
      (response)=>{console.log(response);
      this.router.navigate(['login']);  
    }
    ,(error)=>{
      console.log(error);
      this.message=error.error.message;
    });
  }
}
