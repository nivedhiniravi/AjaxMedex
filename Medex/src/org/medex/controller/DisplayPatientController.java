package org.medex.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.medex.beans.Display;
import org.medex.beans.Doctor;
import org.medex.dao.DisplayPatientDao;
import org.medex.dao.DisplayPatientDaoImpl;
import org.medex.service.DisplayPatientService;
import org.medex.service.DisplayPatientServiceImpl;
import org.medex.service.DoctorService;
import org.medex.service.DoctorServiceImpl;

import com.google.gson.Gson;


@WebServlet("/getDetails")
public class DisplayPatientController extends HttpServlet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DisplayPatientService service=new DisplayPatientServiceImpl();
	//DisplayDao service=new DisplayDaoImpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		  HttpSession session=request.getSession();
          String id=(String) session.getAttribute("id");
          String role=(String) session.getAttribute("role");
		response.setContentType("text/html");
		String dateInString =request.getParameter("a_app_date");
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		 Display d=new Display();
		 List<Display> res = null;
        try {
           Date date = formatter.parse(dateInString);
           
            d.setAppDate(formatter.format(date));
            if(role.contentEquals("patient"))
            {
            	res=service.viewPatient(d,id);
            }
            else
            {
            	res=service.viewDoctor(d,id);
            }
            

        } catch (ParseException e) {
            e.printStackTrace();
        }
           
       PrintWriter pw=response.getWriter();
	   List<Display> emps=res;
		Gson gson=new Gson();
		String jsonRes=gson.toJson(emps);
		System.out.println(jsonRes);
		pw.println(jsonRes);
		pw.close();
	}
}
