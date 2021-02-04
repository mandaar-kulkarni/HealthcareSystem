import { Component, OnInit } from '@angular/core';
import { AppointmentDTO } from 'src/app/dto/AppointmentDTO';
import { Appointment } from 'src/app/pojos/appointment';
import { Doctor } from 'src/app/pojos/doctor';
import { Patient } from 'src/app/pojos/patient';
import { PatientService } from 'src/app/services/patient.service';

@Component({
  selector: 'app-booking-appointment',
  templateUrl: './booking-appointment.component.html',
  styleUrls: ['./booking-appointment.component.css']
})
export class BookingAppointmentComponent implements OnInit {

  appointment= new Appointment("");
  departmentName:string;
  doctorId:number;
  message:string;
  listOfDoctor:Doctor[];
  patient:Patient;
  listOfTime:string[]=["10-11","11-12","12-01","01-02"];
  appointmentTime:string;
  appointmentDate:Date;
  appointmentDto:AppointmentDTO=new AppointmentDTO();
  department:Array<string> = ['PODIATRIST', 'PEDIATRICIAN', 'NEUROLOGIST', 'ALLERGIST', 'SURGEON', 'OPHTHALMOLOGIST', 'DERMATOLOGIST', 'CARDIOLOGIST', 'ORTHOPEDIST'];

  constructor(private service:PatientService) { }

  ngOnInit(): void {
  }
  bookAppointment(){
    this.appointmentDto.appointmentDate=this.appointmentDate;
    this.appointmentDto.appointmentTime=this.appointmentTime;
    this.appointmentDto.doctorId=this.doctorId;
    this.patient=JSON.parse(sessionStorage.getItem("patient") || '{}');
    this.appointmentDto.patientId=this.patient.patientId;

    this.service.bookAppointment(this.appointmentDto).subscribe(response=>{
      this.message=response;
    },error=>{
      this.message=error.error.message;
    })
  }

  public onDepartment(event:any){
    // this.departmentName = event.target.files[0];
    console.log(this.departmentName);
    this.getListOfDoctor(this.departmentName);
  }

  getListOfDoctor(departmentName:string){
    this.service.getListOfDoctor(departmentName).subscribe(response=>{
      this.listOfDoctor=response;
      console.log(this.listOfDoctor);
    },error=>{
      this.message=error.error.message;
    })
  }

}
