import { Medicine } from "../pojos/medicine";
import { PrescriptionMedicineDTO } from "../pojos/prescription";

export class MedPres{

  presc:PrescriptionMedicineDTO;
  medicine:Medicine[];

  constructor(presc,medicine) {
    this.medicine=medicine;
    this.presc=presc;
  }
}
