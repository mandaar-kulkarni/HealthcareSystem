import { Doctor } from '../pojos/doctor';
import { Patient } from '../pojos/patient';
import { User } from '../pojos/user';
export class UserProperty{
    patient:Patient;
    doctor?:Doctor;
    admin?:User;
    role:string;
    constructor(patient:Patient,role:string){
        this.patient=patient;
        this.role=role;
    }
}
