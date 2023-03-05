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
import com.zerock.myapp.entity.SanParty;
import com.zerock.myapp.service.CommentService;
import com.zerock.myapp.service.PartyService;
import com.zerock.myapp.service.ReviewService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/PartyDetail")
public class PartyDetailController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		Integer id = Integer.parseInt(req.getParameter("id"));


		try {
			 	
			PartyService serviceP = new PartyService();
			CommentService serviceC = new CommentService();

			
			SanParty party;
			LinkedBlockingDeque<Comment> comments;

			
			
			party = serviceP.getParty(id);
			comments = serviceC.getComments("SAN_PARTY", id);
			
			
			
			req.setAttribute("p", party);
			req.setAttribute("listC", comments);
			
			req.getRequestDispatcher("party-detail/PartyDetail.jsp").forward(req, res);
			
		} catch (NamingException | ClassNotFoundException e1) {
			
			e1.printStackTrace();
			throw new ServletException(e1);
		}

	}

}
