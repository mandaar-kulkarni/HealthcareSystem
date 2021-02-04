import { Medicine } from '../../pojos/medicine';
import { Component, OnInit } from '@angular/core';
import { DoctorService } from 'src/app/services/doctor.service';
import { Router } from '@angular/router';
import { MedPres } from 'src/app/dto/medPres';
import { PrescriptionDTO } from 'src/app/dto/PrescriptionDto';


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
  message: string = "";
  quantity: number = 0;
  listOfMedicine: Medicine[] = [];
  showtable: boolean = false;
  patientId:number;
  prescriptionDTO: PrescriptionDTO=new PrescriptionDTO();
  appointmentTime:string;

  constructor(private service:DoctorService,private router:Router ) {
    this.patientId=this.router.getCurrentNavigation().extras.queryParams.patientId;
    this.appointmentTime=this.router.getCurrentNavigation().extras.queryParams.time;
    console.log(this.patientId);
   }

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
    var doc1=JSON.parse(sessionStorage.getItem("doctor"));
    console.log(doc1.doctorId);
    this.prescriptionDTO.doctorId=doc1.doctorId;
    this.prescriptionDTO.patientId=this.patientId;
    this.prescriptionDTO.precautions=this.precaution;
    this.prescriptionDTO.symptoms=this.symptoms;
    this.prescriptionDTO.appointmentTime=this.appointmentTime;
    this.prescriptionDTO.listOfMedicine=this.listOfMedicine;
      this.service.savePrescription(this.prescriptionDTO).subscribe(resp=>{
        console.log(resp);
        this.router.navigate(['listofappointment']);
      },error=>{
          this.message=error.error.message;
      });
  }
}
