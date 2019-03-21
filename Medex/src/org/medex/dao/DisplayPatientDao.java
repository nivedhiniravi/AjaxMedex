package org.medex.dao;

import java.util.List;

import org.medex.beans.Display;



public interface DisplayPatientDao {
	List<Display> viewAppointmentPatient(Display d,String id);
	List<Display> viewAppointmentDoctor(Display d,String id);
}
