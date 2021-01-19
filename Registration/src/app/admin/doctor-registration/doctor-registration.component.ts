import { User } from '../../user';
import { Component, OnInit } from '@angular/core';
import { Doctor } from '../../doctor';
import { FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-doctor-registration',
  templateUrl: './doctor-registration.component.html',
  styleUrls: ['./doctor-registration.component.css']
})
export class DoctorRegistrationComponent {

  doctor=new Doctor("","","",new Date(),"","","");
  user=new User("","","DOCTOR");
  //confirmPassword:string="";
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

  registerDoctor(){
    console.log(this.doctorForm.valid);

    if(this.doctorForm.valid){
      console.log(this.doctorForm.value);
    }

    this.user.emailId=this.doctor.emailId;
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


//  Validations Methods
 doctorForm=new FormGroup({
  firstName:new FormControl('',[Validators.required,Validators.maxLength(15)]),
  lastName:new FormControl('',[Validators.required,Validators.maxLength(15)]),
  gender:new FormControl('',Validators.required),
  dateOfBirth:new FormControl('',Validators.required),
  address:new FormControl('',[Validators.required, Validators.maxLength(50)]),
  phoneNumber:new FormControl('',[Validators.required,Validators.pattern("^[0-9]{10}$")]),
  emailId:new FormControl('',[Validators.required,Validators.pattern("^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$"),Validators.maxLength(50)]),
  password:new FormControl('',[Validators.required, Validators.maxLength(15)]),
  confirmPassword:new FormControl('',[Validators.required, Validators.pattern(this.user.password)]),
});

  get firstName(){
   return this.doctorForm.get('firstName')
  }
  get lastName(){
    return this.doctorForm.get('lastName')
   }

  get gender(){
    return this.doctorForm.get('gender')
  }

  get dateOfBirth(){
    return this.doctorForm.get('dateOfBirth')
  }

  get address(){
    return this.doctorForm.get('address')
  }

  get phoneNumber(){
    return this.doctorForm.get('phoneNumber')
  }

  get emailId(){
    return this.doctorForm.get('emailId')
  }

  get password(){
    return this.doctorForm.get('password')
  }

  get confirmPassword(){
    return this.doctorForm.get('confirmPassword')
  }

}
