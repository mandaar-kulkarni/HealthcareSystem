import { Patient } from './patient';
import { Doctor } from './doctor';
export class Appointment {
  appointmentId?:number;
  appointmentTime?: string;
  doctor?:Doctor;
  patient?:Patient;

  constructor(appTime:string){
    this.appointmentTime=appTime;
  }
}
