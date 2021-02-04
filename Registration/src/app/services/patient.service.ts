import { MedPrescription } from '../dto/Prescription';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appointment } from '../pojos/appointment';
import { Doctor } from '../pojos/doctor';
import { AppointmentDTO } from '../dto/AppointmentDTO';

@Injectable({
  providedIn: 'root'
})
export class PatientService {

  constructor(private http:HttpClient) { }

  getAppointmentList(id:any):Observable<Appointment[]>{
      return this.http.get<Appointment[]>("http://localhost:8080/patient/getAppointmentList/"+id);
  }

  getPrescription(id:any):Observable<MedPrescription[]>{
    return this.http.get<MedPrescription[]>("http://localhost:8080/patient/getPrescription/"+id);
  }

  getListOfDoctor(departmentName:string):Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:8080/patient/getDoctorBySpecification/"+ departmentName);
  }

  bookAppointment(appointmentDto:AppointmentDTO){
    return this.http.post("http://localhost:8080/patient/bookAppointment",appointmentDto, { responseType: 'text'});
  }

}
