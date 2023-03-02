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
@WebServlet("/UpdateReview")
public class UpdateReviewController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		/*
		 * 생각해보니까 타겟GB를 받을거면 여기서 구분해서 gb에 따라 게시판 나눠서 글넣기는 가능한데 과연 그게 나을지 CRUD 컨트롤러를
		 * 게시판마다 다 만드는게 나은지??
		 */

		String current = req.getParameter("current");

//		String gb = req.getParameter("targetGb");
		int sanReviewCd = Integer.parseInt(req.getParameter("targetReview"));

		int userCd = 2;
//		String userCd = req.getParameter("userCd");

//		String contents = req.getParameter("contents").replaceAll("\r\n", "<br>");
		String contents = req.getParameter("contents");

		try {

			ReviewService service = new ReviewService();


			res.sendRedirect(current);

		} catch (NamingException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
	}

}
