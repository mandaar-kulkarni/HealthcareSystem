import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { MedPres } from '../dto/medPres';
import { MedPrescription } from '../dto/Prescription';
import { PrescriptionDTO } from '../dto/PrescriptionDto';
import { Appointment } from '../pojos/appointment';
import { Medicine } from '../pojos/medicine';
import { PrescriptionMedicineDTO } from '../pojos/prescription';

@Injectable({
  providedIn: 'root'
})
export class DoctorService {

  constructor(private http:HttpClient) { }

  getAppointmentList(id:any):Observable<Appointment[]>{
    return this.http.get<Appointment[]>("http://localhost:8081/doctor/getAppointment/"+id);
  }

  getPrescription(id:number):Observable<Medicine[]>{
    return this.http.get<Medicine[]>("http://localhost:8081/doctor/getPrescription/"+id);
  }

  savePrescription(prescriptionDTO:PrescriptionDTO){
    return this.http.post("http://localhost:8081/doctor/saveprescription",prescriptionDTO);
  }

}
