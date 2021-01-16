export class User {
    userId?:number;
    emailId:string;
    password:string;
    personRole?:string;

    constructor(emailId:string,password:string,personRole?:string){
        this.emailId=emailId;
        this.password=password;
        this.personRole=personRole;
    }
}
