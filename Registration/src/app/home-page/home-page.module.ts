import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';
import { EmergencyComponent } from './emergency/emergency.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RouterModule } from '@angular/router';



@NgModule({
  declarations: [
    EmergencyComponent,
    HomeComponent,
    LoginComponent
  ],
  imports: [
    CommonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule
  ]
})
export class HomePageModule { }
