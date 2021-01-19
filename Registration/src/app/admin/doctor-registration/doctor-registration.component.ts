import { User } from '../../user';
import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../doctor';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  doctor=new Doctor("","","",new Date(),"","","");
  user=new User("","","DOCTOR");
  confirmPassword:string="";
  degreeCertificate: File | undefined;
  license: File | undefined;
  constructor() { }

  ngOnInit(): void {
  }

  public onFileChanged(event:any) {
    console.log(event);
    this.degreeCertificate = event.target.files[0];
  }
  public onFileChanged1(event:any) {
    console.log(event);
    this.license = event.target.files[0];
  }
  //event handler function called when Upload btn is clicked
  //onUpload() {
    // this.uploadService.uploadFile(this.degreeCertificate,this.license,this.doctor).subscribe(
    //   resp => {
    //     console.log(resp);
    //     this.message = resp;
    //   }
    // );
 // }

  registerDoctor(){
    this.user.emailId=this.doctor.emailId;
    console.log(this.doctor);
    console.log(this.user);
  }}
