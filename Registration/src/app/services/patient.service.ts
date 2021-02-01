import { MedPrescription } from '../dto/Prescription';
import { Observable } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Appointment } from '../pojos/appointment';

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

}
