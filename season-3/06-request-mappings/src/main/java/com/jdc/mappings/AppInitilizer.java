package com.jdc.mappings;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class AppInitilizer implements WebApplicationInitializer {

	@Override
	public void onStartup(ServletContext container) throws ServletException {

		var rootContext = new AnnotationConfigWebApplicationContext();
		rootContext.register(RootConfig.class);
		container.addListener(new RootConfigLoaderListener(rootContext));
		
		var mvcContext = new AnnotationConfigWebApplicationContext();
		mvcContext.register(ServletConfig.class);
		var servlet = container.addServlet("dispathcer", new DispatcherServlet(mvcContext));
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
	}
}
