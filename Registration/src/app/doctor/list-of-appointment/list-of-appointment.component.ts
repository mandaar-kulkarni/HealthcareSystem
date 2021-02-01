import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/pojos/doctor';
import { DoctorService } from 'src/app/services/doctor.service';

@Component({
  selector: 'app-list-of-appointment',
  templateUrl: './list-of-appointment.component.html',
  styleUrls: ['./list-of-appointment.component.css']
})
export class ListOfAppointmentComponent implements OnInit {

  doctor:Doctor;
  constructor(private service:DoctorService) {
    this.doctor=JSON.parse(sessionStorage.getItem("doctor") || '{}');
    this.appointmentList();
  }

  ngOnInit(): void {
  }
  appointmentList(){
    this.service.getAppointmentList
  }
}
