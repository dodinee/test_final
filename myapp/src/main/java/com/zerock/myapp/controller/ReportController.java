package com.zerock.myapp.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.service.CommentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/Report")
public class ReportController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
		
		String current = req.getParameter("current");
		
		String targetGb = req.getParameter("targetGb");
		
		int targetCd = Integer.parseInt(req.getParameter("targetCd"));
		
		int userCd = 2;
//		int userCd = Integer.parseInt(req.getParameter("userCd"));
		
		String reportGb = req.getParameter("check");

		CommentService service;

		
		try {

			if (targetGb.equals("COMMENT")) {

				service = new CommentService();
				service.reportComment(targetCd, userCd, reportGb);
				
				res.sendRedirect(current);
//				req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
			}

		} catch (NamingException e) {
			
			e.printStackTrace();
		}
	}

}
