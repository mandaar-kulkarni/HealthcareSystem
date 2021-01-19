import { Prescription } from './../../prescription';
import { Medicine } from './../../medicine';
import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';


@Component({
  selector: 'app-prescription',
  templateUrl: './prescription.component.html',
  styleUrls: ['./prescription.component.css']
})
export class PrescriptionComponent implements OnInit {
  showPrecaution: boolean = true;
  precaution: string = "";
  symptoms: string = "";
  medicineName: string = "";
  quantity: number = 0;
  listOfMedicine: Medicine[] = [];
  showtable: boolean = false;
  constructor() { }


  ngOnInit(): void {

  }


  addMedicine() {
    if (this.medicineName != "" && this.quantity != 0 ) {
    this.listOfMedicine.push(new Medicine(this.medicineName, this.quantity));
    }
    this.showtable = true;
    this.medicineName = "";
    this.quantity = 0;
    this.showPrecaution = false;
  }

  deleteRow(index: any) {
    if (this.listOfMedicine.length == 1) {
      this.listOfMedicine.splice(index, 1);
      this.showtable = false;
    } else {
      this.listOfMedicine.splice(index, 1);
    }
  }

  showSymptomsPre(){
    this.showPrecaution=true;
  }

  update(medicine: any, index: any) {
    this.medicineName = medicine.medicineName;
    this.quantity = medicine.quantity;
    this.listOfMedicine.splice(index, 1);
  }

  savePrescription() {
    if (this.medicineName != "" && this.quantity != 0) {
      this.listOfMedicine.push(new Medicine(this.medicineName, this.quantity));
    }
    var pre = new Prescription(this.symptoms, this.precaution, new Date(), this.listOfMedicine);
    console.log(pre);
  }

}
