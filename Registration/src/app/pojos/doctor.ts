export class Doctor {
  doctorId?:number;
  firstName:string;
  lastName:string;
  emailId:string;
  dateOfBirth:Date;
  phoneNumber:string;
  address:string;
  gender:string;
  specialization?:string;

  constructor(firstName:string,lastName:string,emailId:string,dateOfBirth:Date,
      phoneNumber:string,address:string,gender:string,specialization:string,doctorId?:number){
          this.firstName=firstName;
          this.lastName=lastName;
          this.emailId=emailId;
          this.dateOfBirth=dateOfBirth;
          this.phoneNumber=phoneNumber;
          this.address=address;
          this.gender=gender;
          this.doctorId=doctorId;
          this.specialization=specialization;
        }
}
