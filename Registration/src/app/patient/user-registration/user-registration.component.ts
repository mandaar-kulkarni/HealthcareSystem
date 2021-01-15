import { User } from '../../user';
import { Component, OnInit } from '@angular/core';
import { Patient } from '../../patient';

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


  constructor() { }

  ngOnInit(): void {
  }

  registerPatient(){
    this.user.emailId=this.patient.emailId;
    console.log(this.patient);
    console.log(this.user);
  }
}
