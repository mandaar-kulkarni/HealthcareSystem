import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { DoctorRegistrationComponent } from './doctor-registration/doctor-registration.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
// import { RegisterComponent } from './register/register.component';
import { UserRegistrationComponent } from './user-registration/user-registration.component';

const routes: Routes = [
  {path:'login',component:LoginComponent},
  {path:'register',component:UserRegistrationComponent},
  {path:'service',component:DoctorRegistrationComponent},
  {path:'',component:HomeComponent}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
