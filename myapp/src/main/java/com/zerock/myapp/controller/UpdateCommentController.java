package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.Objects;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.entity.Comment;
import com.zerock.myapp.service.CommentService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/UpdateComment")
public class UpdateCommentController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

//		String current = req.getParameter("current");
		
		int commentCd = Integer.parseInt(req.getParameter("commentCd"));
		
		String contents = req.getParameter("contents");

		try {

			CommentService service; 
			service = new CommentService();

			service.updateComment(commentCd, contents);

//			res.sendRedirect(current);

		} catch (NamingException e) {
			
			e.printStackTrace();
			throw new ServletException(e);
		}
//		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
	}

}
