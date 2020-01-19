package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.startup.SetContextPropertiesRule;

import dao.FacebookDAO;
import dao.FacebookDAOInterface;
import entity.Employee;

public class RegisterServlet extends HttpServlet {

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String nm=request.getParameter("name");
		String nm1=request.getParameter("pass");
		String nm2=request.getParameter("email");
		String nm3=request.getParameter("address");
		
		Employee ee=new Employee();
		ee.setName(nm);
		ee.setPass(nm1);
		ee.setEmail(nm2);
		ee.setAddress(nm3);
		
		FacebookDAOInterface dd=new FacebookDAO();
		int i=dd.createProfile(ee);
		
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		
		out.println("<html><body>");
		if(i>0){
		out.println("Registration Successful  <br>   <a href=login.html>click here</a>");
		}
		else{
			out.println("could not register");
		}
		out.println("</body></html>");
	}

}
