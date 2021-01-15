import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DoctorRegistrationComponent } from './admin/doctor-registration/doctor-registration.component';
import { ListOfDoctorsComponent } from './admin/list-of-doctors/list-of-doctors.component';
import { ListOfAppointmentComponent } from './doctor/list-of-appointment/list-of-appointment.component';
import { HomeComponent } from './home-page/home/home.component';
import { LoginComponent } from './home-page/login/login.component';
// import { RegisterComponent } from './register/register.component';
import { UserRegistrationComponent } from './patient/user-registration/user-registration.component';

const routes: Routes = [
  {path:'',component:HomeComponent},
  {path:'login',component:LoginComponent},
  {path:'register',component:UserRegistrationComponent},
  {path:'service',component:DoctorRegistrationComponent},
  {path:'listofdoctor',component:ListOfDoctorsComponent},
  {path:'listofappointment',component:ListOfAppointmentComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
