import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Emergency } from './pojos/emergency';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'StayFit';
  emergency =new Emergency("","","");
  message="";
  showForm:boolean=false;
  constructor(private router:Router) { }

  ngOnInit(): void {
  }

  saveDetails(){
    console.log(this.emergency);
    this.showForm=true;
    this.message="We will reach you shortly!!!";
    this.emergency.symptoms='';
    this.emergency.name='';
    this.emergency.phoneNumber='';
  }

  logout(){
    sessionStorage.clear();
    this.router.navigate(['login']);
  }
  cancellation(){
    this.showForm=false;
    // this.emergency.symptoms='';
    // this.emergency.name='';
    // this.emergency.phoneNumber='';
  }
}
