import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListOfDoctorsComponent } from './list-of-doctors/list-of-doctors.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    ListOfDoctorsComponent,
    DoctorRegistrationComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ]
})
export class AdminModule { }
