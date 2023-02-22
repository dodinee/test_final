package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.entity.Comment;
import com.zerock.myapp.entity.SanReview;
import com.zerock.myapp.service.CommentService;
import com.zerock.myapp.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/ReviewDetail")
public class ReviewDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		int id = Integer.parseInt(req.getParameter("id"));

		ReviewService service;
		try {
			service = new ReviewService();

			CommentService serviceC = new CommentService();

			SanReview review;
			LinkedBlockingDeque<Comment> comments;

			review = service.getReview(id);
			comments = serviceC.getComments("SAN_REVIEW", id);
			
			req.setAttribute("r", review);
			req.setAttribute("listC", comments);
			
			req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
			
		} catch (NamingException | ClassNotFoundException e1) {
			e1.printStackTrace();
		}

	}

}
