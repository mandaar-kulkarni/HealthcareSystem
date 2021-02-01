import { Component, OnInit } from '@angular/core';
import { Appointment } from 'src/app/pojos/appointment';
import { Doctor } from 'src/app/pojos/doctor';

@Component({
  selector: 'app-booking-appointment',
  templateUrl: './booking-appointment.component.html',
  styleUrls: ['./booking-appointment.component.css']
})
export class BookingAppointmentComponent implements OnInit {

  appointment= new Appointment(new Date());

  doctor=new Doctor("","","",new Date(),"","","","");

  department:Array<string> = ['PODIATRIST', 'PEDIATRICIAN', 'NEUROLOGIST', 'ALLERGIST', 'SURGEON', 'OPHTHALMOLOGIST', 'DERMATOLOGIST', 'CARDIOLOGIST', 'ORTHOPEDIST'];

  constructor() { }

  ngOnInit(): void {
  }
  bookAppointment(){

  }


}
