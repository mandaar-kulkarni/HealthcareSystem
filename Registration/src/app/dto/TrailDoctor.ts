import { User } from '../pojos/user';
import { Doctor } from '../pojos/doctor';
export class TrailDoctor{
    doctor:Doctor;
    user:User;

    constructor(doctor:Doctor,user:User){
        this.doctor=doctor;
        this.user=user;
    }
}
