import { Component, OnInit } from '@angular/core';
import { Emergency } from 'src/app/pojos/emergency';

@Component({
  selector: 'app-emergency',
  templateUrl: './emergency.component.html',
  styleUrls: ['./emergency.component.css']
})
export class EmergencyComponent implements OnInit {

  emergency:Emergency;
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
