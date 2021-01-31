import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Doctor } from './doctor';
import { TrailDoctor } from './dto/TrailDoctor';

@Injectable({
  providedIn: 'root'
})
export class AdminService {

  constructor(private http:HttpClient) { }

  listOfDoctor():Observable<Doctor[]>{
    return this.http.get<Doctor[]>("http://localhost:8080/admin/getdoctors");
  }

  registerDoctor(trailDoc:TrailDoctor):Observable<Doctor>{
    return this.http.post<Doctor>("http://localhost:8080/admin/regDoctor",trailDoc);
  }
}
