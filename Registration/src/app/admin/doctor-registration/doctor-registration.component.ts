import { User } from '../../pojos/user';
import { Component, OnDestroy, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { TrailDoctor } from 'src/app/dto/TrailDoctor';
import { AdminService } from 'src/app/services/admin.service';
import { Doctor } from 'src/app/pojos/doctor';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent implements OnInit, OnDestroy{
  department:Array<string> = ['PODIATRIST', 'PEDIATRICIAN', 'NEUROLOGIST', 'ALLERGIST', 'SURGEON', 'OPHTHALMOLOGIST', 'DERMATOLOGIST', 'CARDIOLOGIST', 'ORTHOPEDIST'];
//this is for passing data via service
//object:TrailDoctor =new TrailDoctor(new Doctor("","","",new Date(),"","","",""),new User("",""));

  doctor=new Doctor("","","",new Date(),"","","","");
  user=new User("","","DOCTOR");
  confirmPassword:string="";
  message:string="";
  degreeCertificate: File =null;
  license: File =null;

  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
    if(sessionStorage.getItem('doctorObject') != null && sessionStorage.getItem('doctorObject') != null ){
      this.doctor=JSON.parse(sessionStorage.getItem('doctorObject') || '{}');
      this.user=JSON.parse(sessionStorage.getItem('userObject') || '{}');
      this.confirmPassword=this.user.password;
    }
//this is for passing data via service
    //  this.object=this.service.getObject();
  }

  ngOnDestroy():void{
    if(sessionStorage.getItem('doctorObject') != null && sessionStorage.getItem('userObject') != null ){
      sessionStorage.removeItem('doctorObject');
      sessionStorage.removeItem('userObject');
    }
  }

  registerDoctor(){
    this.user.emailId=this.doctor.emailId;
    console.log(this.doctor);
    console.log(this.user);
    this.ngOnDestroy();
    this.service.registerDoctor(new TrailDoctor(this.doctor,this.user))
    .subscribe(
      (response)=>{
        console.log(response);
        this.uploadImage(this.doctor);
      this.router.navigate(['listofdoctor']);
    }
    ,(error)=>{
      console.log(error);
      this.message=error.error.message;
    });
  }

  public onFileChanged(event:any) {
    console.log(event);
    this.degreeCertificate = event.target.files[0];
  }
  public onFileChanged1(event:any) {
    console.log(event);
    this.license = event.target.files[0];
  }

  uploadImage(doctor:Doctor){
    this.service.uploadImage(this.degreeCertificate ,this.license,doctor).subscribe(
      (response)=>{
      console.log(response);
    },(error)=>{
      this.message=error.error.message;
    });
  }
}
