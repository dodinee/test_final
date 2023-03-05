package com.zerock.myapp.controller;

import java.io.IOException;

import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.zerock.myapp.service.ReportService;

import lombok.extern.log4j.Log4j2;

@Log4j2
@WebServlet("/Report")
public class ReportController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		
//		if ("application/json".equals(req.getContentType())) {
//			
//			BufferedReader reader = req.getReader();
//			StringBuilder sb = new StringBuilder();
//			String line;
//			
//			while ((line = reader.readLine()) != null) {
//				
//				sb.append(line);
//			}// while
//			
//			String jsonData = sb.toString();
//
//			// JSON 데이터 형식 변환 
//			ObjectMapper objectMapper = new ObjectMapper();
//		
//			// ...
//		} else {
//			// Content-Type이 application/json이 아닐 경우 처리
//			// ...
//		}
		
		
		
// JSON 안해 안됨 안해 두번다시 보지말자 
		
//			
//		JSONParser parser = new JSONParser();
//		JSONObject formData = (JSONObject) parser.parse();
//		
//		
//		String current = (String) formData.get("current");
//		String targetGb = (String) formData.get("targetGb");
//		int targetCd = (int) formData.get("targetCd");
//		int userCd = (int) formData.get("userCd");
//		String reportGb = (String) formData.get("reportGb");
		
		
// GET 
		String targetGb = req.getParameter("targetGb");
		
		int targetCd = Integer.parseInt(req.getParameter("targetCd"));
		
		int userCd = Integer.parseInt(req.getParameter("userCd"));
		
		String reportGb = req.getParameter("reportGb");

		try {
			
			ReportService service = new ReportService();
			
			service.insertReport(targetGb, targetCd, userCd, reportGb);
			
		} catch (NamingException e) {

			e.printStackTrace();
		}// try-catch
	}// service

}// end class
