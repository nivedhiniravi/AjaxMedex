package org.medex.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.medex.util.DBConstants;
import org.medex.util.DBUtil;
import org.medex.beans.Display;

public class DisplayPatientDaoImpl implements DisplayPatientDao {

	@Override
	public List<Display> viewAppointmentPatient(Display d, String id) {
		List<Display> display = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		try {
			con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,
					DBConstants.UNAME, DBConstants.PWD);

			String selectQuery = "select * from appointment where date_of_app=? and pat_id=?";
			pst = con.prepareStatement(selectQuery);
			pst.setString(1, d.getAppDate());
			pst.setString(2, id);
			rs = pst.executeQuery();

			while (rs.next()) {

				Display d1 = new Display();
				String selectDoctor = "select * from doctor where did=?";
				pst = con.prepareStatement(selectDoctor);
				pst.setString(1, rs.getString(3));
				rs1 = pst.executeQuery();
				if (rs1.next()) {
					d1.setDocName(rs1.getString(2));
					d1.setDocCategory(rs1.getString(7));

				}

				d1.setAppBookDate(rs.getString(6));
				d1.setAppDate(rs.getString(4));
				d1.setTimeSlot(rs.getString(5));
				display.add(d1);
				rs1.close();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return display;
	}

	@Override
	public List<Display> viewAppointmentDoctor(Display d, String id) {
		
		List<Display> display = new ArrayList<>();
		Connection con = null;
		PreparedStatement pst = null;
		ResultSet rs = null;
		ResultSet rs1 = null;

		try {
			con = DBUtil.getConnection(DBConstants.DRIVER, DBConstants.URL,
					DBConstants.UNAME, DBConstants.PWD);

			String selectQuery = "select * from appointment where date_of_app=? and doc_id=?";
			pst = con.prepareStatement(selectQuery);
			pst.setString(1, d.getAppDate());
			pst.setString(2, id);
			rs = pst.executeQuery();

			while (rs.next()) {

				Display d1 = new Display();
				String selectPatient = "select * from patient where pid=?";
				pst = con.prepareStatement(selectPatient);
				pst.setString(1, rs.getString(2));
				rs1 = pst.executeQuery();
				if (rs1.next()) {
					d1.setPatName(rs1.getString(2));
					d1.setPatContactNo(rs1.getString(6));
					d1.setPatEmail(rs1.getString(7));
					d1.setPatAddress(rs1.getString(8));
					d1.setPatGender(rs1.getString(5));

				}

				d1.setAppBookDate(rs.getString(6));
				
				display.add(d1);
				rs1.close();
			}
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return display;
	}
}
