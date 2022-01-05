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
		
		var async = req.startAsync();
		async.setTimeout(5000);
		
		out.append("""
				<html>
				<head>
				<title>Async Servlet</title>
				</head>
				<body>
				<h1>Hello Async Servlet</h1>
				""");
		
		async.start(getTask("Job 1"));
		async.complete();
		
		out.append("""
				<p>This is heavy weight Process</p>
				<a href="async">Request Again</a>
				</body>
				</html>
				""");
	}
	
	private Runnable getTask(String name) {
		return () -> {
			try {
				System.out.println("Heavy Weight work %s start!".formatted(name));
				Thread.sleep(5000);
				System.out.println("Heavy Weight work %s end.".formatted(name));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}
}
