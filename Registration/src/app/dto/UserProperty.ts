import { Patient } from './../patient';
export class UserProperty{
    patient:Patient;
    role:string;
    constructor(patient:Patient,role:string){
        this.patient=patient;
        this.role=role;
    }
}