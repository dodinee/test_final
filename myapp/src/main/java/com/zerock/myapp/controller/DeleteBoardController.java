package com.zerock.myapp.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/Delete")
public class DeleteBoardController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		String targetGb = req.getParameter("targetGb");
		int targetCd = Integer.parseInt(req.getParameter("targetCd"));

		try {
			
			if(targetGb.equals("SAN_REVIEW")) {
				
			ReviewService service = new ReviewService();
 
			service.deleteReview(targetCd);
			}

		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
//		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
		// 삭제 후에 해당 게시판 목록페이지로 넘ㄴ겨야함 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

}
