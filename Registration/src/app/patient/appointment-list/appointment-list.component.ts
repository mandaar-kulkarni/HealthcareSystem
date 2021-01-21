import { MedPrescription } from './../../dto/Prescription';
import { PatientService } from './../../patient.service';
import { Appointment } from './../../appointment';
import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/patient';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  patient1:Patient;
  constructor(private service:PatientService) {
    this.patient1=JSON.parse(sessionStorage.getItem("patient") || '{}');
    this.getAllPreviousAppointment();
   }
  appointment:Appointment[]=[];
  showTable:boolean=true;
  showPrescription:boolean=false;
  patient=new Patient("","","","","","","");
  patient2=new Patient("","","","","","","");
  message:string="";
  message1:string="";
  medPrescription:MedPrescription[]=[];
  ngOnInit(): void {
  }

  getAllPreviousAppointment(){
    this.service.getAppointmentList(this.patient1.patientId).subscribe((response)=>{
      this.appointment=response;
      console.log(this.appointment);
    },(error)=>{
      this.message=error.error.message;
    })
  }

  getInvoice(){
    console.log(this.patient1.patientId);
  }

  getPrescription(){
    this.service.getPrescription(this.patient1.patientId).subscribe((response)=>{
      console.log(response);
      this.medPrescription=response;
      this.showTable=false;
      this.showPrescription=true;
    },(error=>{
      this.message1=error.error.message;
    }))
  }

  gotoAppointmentList(){
    this.showTable=true;
    this.showPrescription=false;
  }
}
