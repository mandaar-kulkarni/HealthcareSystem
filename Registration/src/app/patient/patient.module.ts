import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { InvoiceComponent } from './invoice/invoice.component';
import { AppointmentListComponent } from './appointment-list/appointment-list.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    InvoiceComponent,
    AppointmentListComponent,
    UserRegistrationComponent
  ],
  imports: [
    CommonModule,
    ReactiveFormsModule,
    FormsModule,
    RouterModule
  ]
})
export class PatientModule { }
