package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.entity.SanReview;
import com.zerock.myapp.service.ReviewService;

import lombok.extern.log4j.Log4j2;



@Log4j2
@WebServlet("/SanReviewList")
public class ReviewListController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String field_ = req.getParameter("f");
		String query_ = req.getParameter("q");
		String page_ = req.getParameter("p");
		
		
		String field = "title";
		if(field_ != null && !field_.equals("")) { field = field_;}
		
		
		String query = "";
		if(query_ != null && !query_.equals("")) { query = query_;}
		
		
		int page = 1;
		if(page_ != null) { page = Integer.parseInt(page_);}
		
		
		ReviewService service;
		try {
			service = new ReviewService();
		
			LinkedBlockingDeque<SanReview> list = service.getReviewList(field, query, page);
//		int cnt = service.getNoticeCount(field, query);

		req.setAttribute("list", list);
//		req.setAttribute("cnt", cnt);
		req.getRequestDispatcher("main/index.jsp").forward(req, res);
		
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
}
