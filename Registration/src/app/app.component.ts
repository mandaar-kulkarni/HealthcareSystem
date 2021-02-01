import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { Emergency } from './pojos/emergency';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'Registration';
    emergency =new Emergency("","","");
  message="";
  showForm:boolean=true;
  constructor() { }

  ngOnInit(): void {
  }

  saveDetails(){
    console.log(this.emergency);
    this.showForm=false;
    this.message="We will reach you shortly!!!";
  }
}
