export class Appointment {
  appointmentId?:number;
  appointmentTime: Date;

  constructor(appTime:Date){
    this.appointmentTime=appTime;
  }
}
