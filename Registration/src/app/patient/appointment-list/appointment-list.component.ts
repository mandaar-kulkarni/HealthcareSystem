import { Component, OnInit } from '@angular/core';
import { Patient } from 'src/app/patient';

@Component({
  selector: 'app-appointment-list',
  templateUrl: './appointment-list.component.html',
  styleUrls: ['./appointment-list.component.css']
})
export class AppointmentListComponent implements OnInit {

  constructor() { }
  patient=new Patient("","","","","","","");
  ngOnInit(): void {
  }

}
