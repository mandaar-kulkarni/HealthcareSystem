import { Medicine } from "../pojos/medicine";

export class PrescriptionDTO {
    prescriptionId?:number;
    symptoms:string;
    precautions:string;
    //createdOn:Date;
    listOfMedicine:Medicine[];
    patientId:number;
    doctorId:number;
    appointmentTime:string;

}
