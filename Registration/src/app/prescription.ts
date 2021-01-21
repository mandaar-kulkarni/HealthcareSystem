import { Medicine } from './medicine';
export class Prescription {
    prescriptionId?:number;
    symptoms:string;
    precautions:string;
    createdOn:Date;
    listOfMedicine:Medicine[]=[];
    constructor(symptoms:string,precation:string,createdOn:Date,listOfMedicine:Medicine[]){
        this.symptoms=symptoms;
        this.precautions=precation;
        this.createdOn=createdOn;
        this.listOfMedicine=listOfMedicine;
    }
}
