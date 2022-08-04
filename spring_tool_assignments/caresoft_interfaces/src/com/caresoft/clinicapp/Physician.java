package com.caresoft.clinicapp;

import java.util.Date;
import java.util.ArrayList;

public class Physician extends User implements HIPAACompliantUser {
// Member Variable
	private ArrayList<String> patientNotes;
	protected int pin;

	public Physician(Integer id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public boolean assignPin(int pin) {
		int length = (int)(Math.log10(pin) + 1);
		if (length != 4) {
			System.out.println(pin);
			return false;
		}
		return true;
	}


	public boolean accessAuthorized(Integer confirmedAuthID) {
		if (this.id == confirmedAuthID) {
			return true;
		}
		return false;
	}
	
	public void newPatientNotes(String notes, String patientName, Date date) {
        String report = String.format(
            "Datetime Submitted: %s \n", date);
        report += String.format("Reported By ID: %s\n", this.id);
        report += String.format("Patient Name: %s\n", patientName);
        report += String.format("Notes: %s \n", notes);
        this.patientNotes.add(report);
    }

	public ArrayList<String> getPatientNotes() {
		return patientNotes;
	}

	public void setPatientNotes(ArrayList<String> patientNotes) {
		this.patientNotes = patientNotes;
	}
	
}
