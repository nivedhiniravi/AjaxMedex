package org.medex.service;

import java.util.List;

import org.medex.beans.Display;
import org.medex.dao.DisplayPatientDao;
import org.medex.dao.DisplayPatientDaoImpl;



public class DisplayPatientServiceImpl implements DisplayPatientService {
	DisplayPatientDao dis =new DisplayPatientDaoImpl();
	@Override
	public List<Display> viewPatient(Display d,String id) {
		List<Display> b=dis.viewAppointmentPatient(d,id);
		
		return b;
	}
	@Override
	public List<Display> viewDoctor(Display d, String id) {
		List<Display> b=dis.viewAppointmentDoctor(d,id);
		return b;
	}
}
