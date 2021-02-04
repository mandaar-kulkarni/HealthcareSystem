import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Appointment } from 'src/app/pojos/appointment';
import { Doctor } from 'src/app/pojos/doctor';
import { Medicine } from 'src/app/pojos/medicine';
import { Patient } from 'src/app/pojos/patient';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-list-of-appointment',
  templateUrl: './list-of-appointment.component.html',
  styleUrls: ['./list-of-appointment.component.css']
})
export class ListOfAppointmentComponent implements OnInit {

  doctor:Doctor;
  listOfAppointment:Appointment[];
  message:string;
  patient:Patient;
  detailPatient:boolean=false;
  detailPrescription:boolean=false;
  medicineHistory:Medicine[]=[];

  constructor(private service:DoctorService,private router:Router) {
    this.doctor=JSON.parse(sessionStorage.getItem("doctor") || '{}');
    this.appointmentList();
  }

  ngOnInit(): void {
  }
  appointmentList(){
    this.service.getAppointmentList(this.doctor.doctorId).subscribe(resp=>{
      console.log(resp);
      this.listOfAppointment=resp;
    },error=>{
      this.message=error.error.message;
    });
  }

  showPatient(patient:Patient){
    this.patient=patient;
    this.detailPatient=true;
    this.detailPrescription=false;
  }

  getPrescription(id:number){
    this.service.getPrescription(id).subscribe(resp=>{
      this.medicineHistory=resp;
      this.detailPrescription=true;
      this.detailPatient=false;
    },error=>{
      this.message=error.error.message;
    })
  }

  gotoAddPrescription(id:number,appointmentTime:string){
    this.router.navigate(['prescription'],{queryParams : {patientId:id,time:appointmentTime }});
  }

}
