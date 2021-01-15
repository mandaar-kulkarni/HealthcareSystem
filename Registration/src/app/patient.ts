export class Patient {
  patientId?:number;
  firstName:string;
  lastName:string;
  emailId:string;
  dateOfBirth:Date;
  phoneNumber:string;
  address:string;
  gender:string;
  age:number;
  // password:string;

  constructor(firstName:string,lastName:string,emailId:string,dateOfBirth:Date,
      phoneNumber:string,address:string,gender:string,age:number,patientId?:number){
          this.firstName=firstName;
          this.lastName=lastName;
          this.emailId=emailId;
          this.dateOfBirth=dateOfBirth;
          this.phoneNumber=phoneNumber;
          this.address=address;
          this.gender=gender;
          this.age=age;
          // this.password=password;
          this.patientId=patientId;

  }
}
