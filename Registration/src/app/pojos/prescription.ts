import { Medicine } from './medicine';
export class PrescriptionMedicineDTO {
    prescriptionId?:number;
    symptoms:string;
    precautions:string;
  //  createdOn:Date;
    // listOfMedicine:Medicine[];
    patientId:number;
    doctorId:number;

    constructor(symptoms:string,precation:string,patientId:number,doctorId:number){
        this.symptoms=symptoms;
        this.precautions=precation;
//this.createdOn=createdOn;
        // this.listOfMedicine=listOfMedicine;
        this.patientId=patientId;
        this.doctorId=doctorId;
    }
}
