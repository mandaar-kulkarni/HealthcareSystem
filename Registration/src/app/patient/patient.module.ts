import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { RouterModule } from '@angular/router';
import { InvoiceComponent } from './invoice/invoice.component';



@NgModule({
  declarations: [
    AppointmentListComponent,
    UserRegistrationComponent,
    InvoiceComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ]
})
export class PatientModule { }
