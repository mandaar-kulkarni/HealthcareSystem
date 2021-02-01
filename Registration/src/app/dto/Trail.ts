import { User } from '../pojos/user';
import { Patient } from '../pojos/patient';
export class Trail{
    patient:Patient;
    user:User;

    constructor(patient:Patient,user:User){
        this.patient=patient;
        this.user=user;
    }
}
