import { Patient } from './patient';
import { Doctor } from './doctor';
export class Appointment {
  appointmentId?:number;
  appointmentTime?: Date;
  doctor?:Doctor;
  patient?:Patient;

  constructor(appTime:Date){
    this.appointmentTime=appTime;
  }
}
