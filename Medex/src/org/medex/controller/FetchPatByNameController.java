package org.medex.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.medex.service.FetchPatByNameService;

import com.google.gson.Gson;


@WebServlet("/patbyname")
public class FetchPatByNameController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public FetchPatByNameController() {
        super();
    }

    FetchPatByNameService f=new FetchPatByNameServiceImpl(); 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session=request.getSession();
        String id=(String) session.getAttribute("id");
		List<String> list=f.fetch(id);
		Gson gson=new Gson();
		String jsonRes=gson.toJson(list);
		System.out.println(jsonRes);
	}

}
