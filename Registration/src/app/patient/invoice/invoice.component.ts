import { Component, OnInit } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { Invoice } from 'src/app/pojos/invoice';

@Component({
  selector: 'app-invoice',
  templateUrl: './invoice.component.html',
  styleUrls: ['./invoice.component.css']
})
export class InvoiceComponent implements OnInit {
  inv = new Invoice(0,250,new Date());

  constructor() { }

  ngOnInit(): void {
  }

}
