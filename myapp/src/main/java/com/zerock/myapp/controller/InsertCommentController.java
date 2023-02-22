package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.StringTokenizer;

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
@WebServlet("/InsertComment")
public class InsertCommentController extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
    

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		//현재페이지가 리뷰/모집 중에 어떤건지 어떻게 알지? 글코드는 몇인지 어떻게 가져오지?
		//걔가 누군지는 세션에서 알아내는건가?
		
		String gb = req.getParameter("targetGb");
		int id = Integer.parseInt(req.getParameter("targetCd"));

		int userCd = 2;
//		String userCd = req.getParameter("userCd");
		String contents = req.getParameter("contents");
		
		
		CommentService service;
		try {
			service = new CommentService();
			
		
		Comment comment = new Comment();
		
		service.insertComment(gb, id, userCd, contents);
		
		res.sendRedirect("/ReviewDetail?id="+id);
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
//		req.getRequestDispatcher("review-detail/ReviewDetail.jsp").forward(req, res);
	}

}
