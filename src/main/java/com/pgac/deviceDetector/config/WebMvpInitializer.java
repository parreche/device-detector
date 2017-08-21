package com.pgac.deviceDetector.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebMvpInitializer implements WebApplicationInitializer {
  @Override
  public void onStartup(ServletContext ctx) throws ServletException {
	  AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
      
      // Manage the lifecycle of the root application context
      ctx.addListener(new ContextLoaderListener(rootContext));
	  
      AnnotationConfigWebApplicationContext webCtx = new AnnotationConfigWebApplicationContext();
      webCtx.register(SpringConfig.class);
      webCtx.setServletContext(ctx);
      ServletRegistration.Dynamic servlet = ctx.addServlet("dispatcher", new DispatcherServlet(webCtx));
      servlet.setLoadOnStartup(1);
      servlet.addMapping("/");
  }
}
