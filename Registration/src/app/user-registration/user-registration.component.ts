import { Component, OnInit } from '@angular/core';
import { Patient } from '../patient';

@Component({
  selector: 'app-user-registration',
  templateUrl: './user-registration.component.html',
  styleUrls: ['./user-registration.component.css']
})
export class UserRegistrationComponent {
  patient=new Patient("","","","","","",null,"");
  confirmPassword:string="";
  constructor() { }

  ngOnInit(): void {
  }

  registerPatient(){
    console.log(this.patient);
  }

}
