import { Component, Input, OnInit, Output } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { User } from 'src/app/pojos/user';
import { Doctor } from 'src/app/pojos/doctor';
import { Router } from '@angular/router';

@Component({
  selector: 'app-list-of-doctors',
  templateUrl: './list-of-doctors.component.html',
  styleUrls: ['./list-of-doctors.component.css']
})
export class ListOfDoctorsComponent implements OnInit {

  user=new User("","","PATIENT");
  doctor = new Doctor("","","",new Date(),"","","","");
  doctorList:Doctor[]=[];
  retrievedImageDC:any;
  retrievedImageLicense:any;
  message:string="";
  retrievedDC:boolean=false;
  retrievedLic:boolean=false;

  constructor(private service:AdminService,private router:Router) {
    this.listOfDoctor();
   }
  ngOnInit(): void {
  }

  listOfDoctor(){
    this.service.listOfDoctor().subscribe((response)=>{
      this.doctorList=response;
      console.log(this.doctorList);
    },(error)=>{
      this.message=error.error.message;
    })
  }

  removeDoctor(id:any){
    this.service.removeDoctor(id).subscribe((response)=>{
      this.listOfDoctor();
    },(error)=>{
      this.message=error.error.message;
    })
  }

  updateDoctor(id:any){
    this.service.updateDoctor(id).subscribe((response)=>{
      console.log(response.doctor);
      console.log(response.user);
      sessionStorage.setItem('doctorObject',JSON.stringify(response.doctor));
      sessionStorage.setItem('userObject',JSON.stringify(response.user));
      this.router.navigate(['regdoctor']);
    },(error)=>{
      this.message=error.error.message;
    })
  }

  showDC(id:any){
    this.service.retriveDC(id).subscribe((resp)=>{
      this.retrievedImageDC = `data:${resp.type};base64,${resp.data}`;
      this.retrievedDC=true;
      this.retrievedLic=false;
    },(error) => {
    if (error.status === 404)
    this.message = "Image Not Found!!!!";
  else
    this.message = `Server Error :${error.message}`;
    this.retrievedImageDC=null;
   })
  }

  showLicense(id:any){
    this.service.retriveLic(id).subscribe((resp)=>{
      this.retrievedImageLicense = `data:${resp.type};base64,${resp.data}`;
      this.retrievedLic=true;
      this.retrievedDC=false;
    },(error) => {
    if (error.status === 404)
    this.message = "Image Not Found!!!!";
  else
    this.message = `Server Error :${error.message}`;
    this.retrievedImageLicense=null;
   })
  }

}
