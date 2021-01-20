import { DoctorModule } from './doctor/doctor.module';
import { PrescriptionComponent } from './doctor/prescription/prescription.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home-page/home/home.component';
import { LoginComponent } from './home-page/login/login.component';
import { DoctorRegistrationComponent } from './admin/doctor-registration/doctor-registration.component';
import { UserRegistrationComponent } from './patient/user-registration/user-registration.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { InvoiceComponent } from './patient/invoice/invoice.component';
import { EmergencyComponent } from './home-page/emergency/emergency.component';
import { AdminModule } from './admin/admin.module';
import { HomePageModule } from './home-page/home-page.module';
import { PatientModule } from './patient/patient.module';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    DoctorModule,
    AdminModule,
    HomePageModule,
    PatientModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
