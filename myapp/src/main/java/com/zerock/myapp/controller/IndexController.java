package com.zerock.myapp.controller;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.LinkedBlockingDeque;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.entity.SanInfo;
import com.zerock.myapp.entity.SanParty;
import com.zerock.myapp.entity.SanReview;
import com.zerock.myapp.service.PartyService;
import com.zerock.myapp.service.ReviewService;
import com.zerock.myapp.service.SanInfoService;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;


@Log4j2
@NoArgsConstructor
@WebServlet("/Index")
public class IndexController extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	
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
		
		
		try {
			
			
		ReviewService serviceR = new ReviewService();
		SanInfoService serviceS = new SanInfoService();
		PartyService serviceP = new PartyService();
		
		
		LinkedBlockingDeque<SanReview> listR = serviceR.getReviewList(field, query, page);
		LinkedBlockingDeque<SanInfo> listS = serviceS.getInfoList("name", query, page);
		LinkedBlockingDeque<SanParty> listP = serviceP.getPartyList(field, query, page);
		
		
		req.setAttribute("listS", listS);
		req.setAttribute("listR", listR);
		req.setAttribute("listP", listP);
		
		
		req.getRequestDispatcher("main/index.jsp").forward(req, res);
		
		
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		req.getRequestDispatcher("mypage/index.jsp").forward(req, res);
		
	}

}
