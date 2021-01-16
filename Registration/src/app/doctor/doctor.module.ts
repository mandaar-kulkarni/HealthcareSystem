import { FormsModule } from '@angular/forms';
import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { ListOfAppointmentComponent } from './list-of-appointment/list-of-appointment.component';
import { PrescriptionComponent } from './prescription/prescription.component';



@NgModule({
  declarations: [ListOfAppointmentComponent, PrescriptionComponent],
  imports: [
    CommonModule,
    FormsModule
  ]
})
export class DoctorModule { }
