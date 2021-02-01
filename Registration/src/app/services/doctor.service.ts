import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Appointment } from '../pojos/appointment';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http:HttpClient) { }

  getAppointmentList(id:any):Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:8081/doctor/getAppointment/"+id);
  }
}
