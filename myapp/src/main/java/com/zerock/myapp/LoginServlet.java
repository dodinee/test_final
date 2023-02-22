package com.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@NoArgsConstructor
@Log4j2
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
  
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String userid = req.getParameter("userid");
		String passwd = req.getParameter("passwd");
		
		
//		res.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = res.getWriter();
		
		try(out){
			
			out.print("<html><body>");
			out.print("userid = " + userid + "<br>");
			out.print("userpw = " + passwd + "<br>");
			out.print("</body></html>");
			
		}catch(Exception e) {
			e.printStackTrace();
		}//try-catch
	}// service

}
