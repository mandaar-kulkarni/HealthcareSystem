import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from './appointment';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http:HttpClient) { }

  getAppointmentList(id:any):Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:8080/doctor/getAppointment/"+id);
  }
}
