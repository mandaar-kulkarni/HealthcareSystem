package com.app.dto;

import java.util.List;

import com.app.pojos.Medicine;
import com.app.pojos.Prescription;

public class MedPres {
	
	private Prescription presc;
	private List<Medicine> medicine;
	public Prescription getPresc() {
		return presc;
	}
	public void setPresc(Prescription presc) {
		this.presc = presc;
	}
	public List<Medicine> getMedicine() {
		return medicine;
	}
	public void setMedicine(List<Medicine> medicine) {
		this.medicine = medicine;
	}
	@Override
	public String toString() {
		return "MedPres [presc=" + presc + ", medicine=" + medicine +"]";
	}
	

}
