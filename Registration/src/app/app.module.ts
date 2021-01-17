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

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    // RegisterComponent,
    DoctorRegistrationComponent,
    UserRegistrationComponent,
    HomeComponent,
    InvoiceComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    DoctorModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
