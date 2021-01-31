import { User } from './../user';
import { Patient } from './../patient';
import { Doctor } from '../doctor';
export class TrailDoctor{
    doctor:Doctor;
    user:User;

    constructor(doctor:Doctor,user:User){
        this.doctor=doctor;
        this.user=user;
    }
}
