package org.medex.service;

import org.medex.beans.Patient;
import org.medex.dao.PatientDao;
import org.medex.dao.PatientDaoImpl;

public class PatientServiceImpl implements PatientService {

	PatientDao p_dao=new PatientDaoImpl() ;
		
		
	@Override
	public String registerPatient(Patient p) {
		
		String b=p_dao.insertRegistration(p);
		
		return b;
	}

}


	