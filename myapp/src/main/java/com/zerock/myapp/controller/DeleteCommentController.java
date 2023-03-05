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
@WebServlet("/DeleteComment")
public class DeleteCommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int commentCd = Integer.parseInt(req.getParameter("targetCd"));

		try {

			CommentService service = new CommentService();
 
			service.deleteComment(commentCd);

		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
//		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
	}

}
