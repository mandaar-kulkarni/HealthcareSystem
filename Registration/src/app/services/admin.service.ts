import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { TrailDoctor } from '../dto/TrailDoctor';
import { Doctor } from '../pojos/doctor';
import { User } from '../pojos/user';

@Injectable({
  providedIn: 'root'
})
export class AdminService {
//this is for passing data via service
//object:TrailDoctor =new TrailDoctor(new Doctor("","","",new Date(),"","","",""),new User("",""));
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

//this is for passing data via service
  // setObject(data:TrailDoctor){
  //   this.object=data;
  // }

  // getObject(){
  //   return this.object;
  // }

}
