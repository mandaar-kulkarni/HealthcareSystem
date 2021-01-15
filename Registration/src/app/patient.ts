export class Patient {
  patientId?:number;
  firstName:string;
  lastName:string;
  emailId:string;
  phoneNumber:string;
  address:string;
  gender:string;
  age:any;
  // password:string;

  constructor(firstName:string,lastName:string,emailId:string,
      phoneNumber:string,address:string,gender:string,age:any,patientId?:number){
          this.firstName=firstName;
          this.lastName=lastName;
          this.emailId=emailId;
          this.phoneNumber=phoneNumber;
          this.address=address;
          this.gender=gender;
          this.age=age;
          // this.password=password;
          this.patientId=patientId;

  }
}
