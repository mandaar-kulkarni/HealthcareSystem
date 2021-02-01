import { Trail } from '../dto/Trail';
import { User } from '../pojos/user';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { UserProperty } from '../dto/UserProperty';
import { Patient } from '../pojos/patient';

@Injectable({
  providedIn: 'root'
})
export class AuthenticateService {

  constructor(private http:HttpClient) { }

  authenticateUser(user:User):Observable<UserProperty>{
    return this.http.post<UserProperty>("http://localhost:8080/user",user);
  }

  registerPatient(trail:Trail):Observable<Patient>{
    return this.http.post<Patient>("http://localhost:8080/patient",trail);
  }

}
