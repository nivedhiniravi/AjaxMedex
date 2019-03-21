package org.medex.service;

import org.medex.beans.Doctor;
import org.medex.dao.DoctorDao;
import org.medex.dao.DoctorDaoImpl;

public class DoctorServiceImpl implements DoctorService {

	DoctorDao d_dao =new DoctorDaoImpl();
	@Override
	public String registerDoctor(Doctor d) {
		String b=d_dao.insertRegistration(d);
		
		return b;
	}

}
