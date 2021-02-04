export class Medicine {
    medicineId?:number;
    medicineName:string;
    quantity:number;

    constructor(medicineName:string,quantity:number){
        this.medicineName=medicineName;
        this.quantity=quantity;
    }
}
