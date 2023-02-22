package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.entity.Comment;
import com.zerock.myapp.service.CommentService;

import lombok.extern.log4j.Log4j2;


@Log4j2
@WebServlet("/Comment")
public class CommentController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String gb = req.getParameter("gb");
		int id = Integer.parseInt(req.getParameter("id"));
		
		CommentService service = new CommentService();
		
		List <Comment> comment;
//		List <Comment> mention;
		
		comment = service.getComments(gb, id);
//		mention = service.getMentions(id);
		
		req.setAttribute("listC",  comment);
//		req.setAttribute("listM", mention);
		
		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
	}

}
