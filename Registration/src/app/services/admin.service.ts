import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TrailDoctor } from '../dto/TrailDoctor';
import { Doctor } from '../pojos/doctor';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }
  listOfDoctor():Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:8082/admin");
  }

  registerDoctor(trailDoc:TrailDoctor):Observable<Doctor>{
    return this.http.post<Doctor>("http://localhost:8082/admin/regDoctor",trailDoc);
  }

  removeDoctor(id:number){
    return this.http.delete("http://localhost:8082/admin/delete/"+id);
  }

  updateDoctor(id:number):Observable<TrailDoctor>{
    return this.http.get<TrailDoctor>("http://localhost:8082/admin/getDoctor/"+id);
  }

  uploadImage(degreeCertificate: File,license: File,doctor:Doctor) {
      const uploadData = new FormData();
      uploadData.append("degreeCertificate", degreeCertificate);
      uploadData.append("license",license);
      uploadData.append("doctor",JSON.stringify(doctor));
      return this.http.post("http://localhost:8082/admin/upload", uploadData, { responseType: 'text' });
    }

  retriveDC(id:number){
      return this.http.get<any>("http://localhost:8082/admin/getCertificate/"+id);
  }

  retriveLic(id:number){
      return this.http.get<any>("http://localhost:8082/admin/getLicense/"+id);
  }

}

