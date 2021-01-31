import { User } from '../../user';
import { Component } from '@angular/core';
import { Doctor } from '../../doctor';
import { Router } from '@angular/router';
import { TrailDoctor } from 'src/app/dto/TrailDoctor';
import { AdminService } from 'src/app/admin.service';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  doctor=new Doctor("","","",new Date(),"","","");
  user=new User("","","DOCTOR");
  confirmPassword:string="";
  message:string=""
  degreeCertificate: File | undefined;
  license: File | undefined;

  constructor(private service:AdminService,private router:Router) { }

  ngOnInit(): void {
  }

  registerDoctor(){
    this.user.emailId=this.doctor.emailId;
    console.log(this.doctor);
    console.log(this.user);
    this.service.registerDoctor(new TrailDoctor(this.doctor,this.user))
    .subscribe(
      (response)=>{
        console.log(response);
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
  //event handler function called when Upload btn is clicked
  //onUpload() {
    // this.uploadService.uploadFile(this.degreeCertificate,this.license,this.doctor).subscribe(
    //   resp => {
    //     console.log(resp);
    //     this.message = resp;
    //   }
    // );
 // }

}
