package com.zerock.myapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Log4j2
@NoArgsConstructor
@WebServlet("/TestServlet")
public class TestServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();

//		@Cleanup
		try (out) {

			String result = """
					<html>
						<body>
							ResponseServlet 요청 성공~
						</body>
					</html>
					""";

			out.print(result);
			out.flush();

		} catch (Exception e) {
			throw new ServletException(e);
		}
	}

}
