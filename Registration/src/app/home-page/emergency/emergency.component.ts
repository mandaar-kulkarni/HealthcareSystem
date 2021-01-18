import { Emergency } from './../../emergency';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-emergency',
  templateUrl: './emergency.component.html',
  styleUrls: ['./emergency.component.css']
})
export class EmergencyComponent implements OnInit {

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
