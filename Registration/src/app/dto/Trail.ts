import { User } from './../user';
import { Patient } from './../patient';
export class Trail{
    patient:Patient;
    user:User;

    constructor(patient:Patient,user:User){
        this.patient=patient;
        this.user=user;
    }
}