import { Component, OnInit } from '@angular/core';
import { AdminService } from 'src/app/admin.service';
import { Doctor } from 'src/app/doctor';
import { User } from 'src/app/user';

@Component({
  selector: 'app-list-of-doctors',
  templateUrl: './list-of-doctors.component.html',
  styleUrls: ['./list-of-doctors.component.css']
})
export class ListOfDoctorsComponent implements OnInit {

  user=new User("","","PATIENT");
  doctor = new Doctor("","","",new Date(),"","","");
  doctorList:Doctor[]=[];

  message:string="";

  constructor(private service:AdminService) {
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

}
