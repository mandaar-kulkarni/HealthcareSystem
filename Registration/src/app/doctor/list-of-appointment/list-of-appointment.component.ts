import { Component, OnInit } from '@angular/core';
import { Doctor } from 'src/app/doctor';
import { DoctorService } from 'src/app/doctor.service';

@Component({
  selector: 'app-list-of-appointment',
  templateUrl: './list-of-appointment.component.html',
  styleUrls: ['./list-of-appointment.component.css']
})
export class ListOfAppointmentComponent implements OnInit {

  doctor:Doctor;
  constructor(private service:DoctorService) {
    this.doctor=JSON.parse(sessionStorage.getItem)
    this.appointmentList();
  }

  ngOnInit(): void {
  }
  appointmentList(){
    this.service.getAppointmentList
  }
}
