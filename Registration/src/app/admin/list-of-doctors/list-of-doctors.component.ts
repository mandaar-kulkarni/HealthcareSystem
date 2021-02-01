import { Component, Input, OnInit, Output } from '@angular/core';
import { AdminService } from 'src/app/services/admin.service';
import { User } from 'src/app/pojos/user';
import { Doctor } from 'src/app/pojos/doctor';
import { Router } from '@angular/router';
import { TrailDoctor } from 'src/app/dto/TrailDoctor';

@Component({
  selector: 'app-list-of-doctors',
  templateUrl: './list-of-doctors.component.html',
  styleUrls: ['./list-of-doctors.component.css']
})
export class ListOfDoctorsComponent implements OnInit {

  user=new User("","","PATIENT");
  doctor = new Doctor("","","",new Date(),"","","","");
  doctorList:Doctor[]=[];
//this is for passing data via service
  // object:TrailDoctor =new TrailDoctor(new Doctor("","","",new Date(),"","","",""),new User("",""));

  message:string="";

  constructor(private service:AdminService,private router:Router) {
    this.listOfDoctor();
   }
  //doctor=new Doctor("","","",new Date(),"","","");
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

//this is for passing data via service
  // updateDoctor(id:any){
  //   this.service.updateDoctor(id).subscribe((response)=>{
  //       this.service.setObject(response);
  //       this.router.navigate(['regdoctor']);
  //   },(error)=>{
  //         this.message=error.error.message;
  //   });
  // }

  showDC(id:any){

  }

  showLicense(id:any){

  }

}
