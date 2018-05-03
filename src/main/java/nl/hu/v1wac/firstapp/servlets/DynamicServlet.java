package nl.hu.v1wac.firstapp.servlets;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet(urlPatterns = "/DynamicServlet.do")
public class DynamicServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			 throws ServletException, IOException {
		 int n1 = Integer.parseInt(req.getParameter("n1"));
		 int n2 = Integer.parseInt(req.getParameter("n2"));
		 String calc = req.getParameter("calc");
		 int result = 0;
		 
		 if (calc.equals("+")) {
			 result = n1+n2;
		 }
		 
		 else if (calc.equals("-")) {
			 result = n1-n2;
		 }
		 
		 else if (calc.equals("*")) {
			 result = n1*n2;
		 }
		 
		 else if (calc.equals("/")) {
			 result = n1/n2;
		 }
		 

		 PrintWriter out = resp.getWriter();
		 resp.setContentType("text/html");
		 out.println("<!DOCTYPE html>");
		 out.println("<html>");
		 out.println(" <title>Dynamic Example</title>");
		 out.println(" <body>");
		 out.println(" <h2>Dynamic webapplication example</h2>");
		 out.println(" <h2>"+n1+calc+n2+  " = " +result +"</h2>");
		 out.println(" </body>");
		 out.println("</html>");
 
 }
}