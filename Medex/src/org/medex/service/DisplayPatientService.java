package org.medex.service;

import java.util.List;

import org.medex.beans.Display;



public interface DisplayPatientService {
	List<Display> viewPatient(Display d,String id);
	List<Display> viewDoctor(Display d,String id);
	
}
