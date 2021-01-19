import { DoctorModule } from './doctor/doctor.module';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { RouterModule } from '@angular/router';
import { AdminModule } from './admin/admin.module';
import { PatientModule } from './patient/patient.module';
import { HomePageModule } from './home-page/home-page.module';
import { InvoiceComponent } from './patient/invoice/invoice.component';

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
    PatientModule,
    HomePageModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
