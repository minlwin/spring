package com.jdc.async;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(
		urlPatterns = "/async",
		asyncSupported = true)
public class HelloAsync extends HttpServlet{

	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		var out = resp.getWriter();
		
		var asyncContext = req.startAsync();
		
		out.append("""
				<html>
				<head>
				<title>Async Servlet</title>
				</head>
				<body>
				<h1>Hello Async Servlet</h1>
				""");
		asyncContext.start(() -> {
			try {
				System.out.println("Heavy Weight work start!");
				Thread.sleep(5000);
				System.out.println("Heavy Weight work end.");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		});
		
		asyncContext.complete();
		
		out.append("""
				<p>This is heavy weight Process</p>
				<a href="async">Request Again</a>
				</body>
				</html>
				""");
	}
}
