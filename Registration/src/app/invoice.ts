export class Invoice {
  invoiceId?: number;
  doctorFee : number;
  totalAmount : number;
  createdOn : Date ;

  constructor(doctorFee:number,totalAmount:number,createdOn:Date){
    this.doctorFee=doctorFee;
    this.totalAmount=totalAmount;
    this.createdOn=createdOn;
  }
}
