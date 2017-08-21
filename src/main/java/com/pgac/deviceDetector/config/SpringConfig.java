package com.pgac.deviceDetector.config;

import java.util.HashMap;
import java.util.Map;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@EnableWebMvc
@Configuration
@ComponentScan(basePackages={"com.pgac.deviceDetector.controller","com.pgac.deviceDetector.filter", "net.sourceforge.wurfl.core"})
public class SpringConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}

	@Override
	public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
		configurer.enable();
	}

	@Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
    	Map<String, MediaType> mediaTypes = new HashMap<>();
    	mediaTypes.put("xml", MediaType.APPLICATION_XML);
    	mediaTypes.put("json", MediaType.APPLICATION_JSON);
    	configurer.favorPathExtension(false).
    	favorParameter(false).
    	useJaf(true).
    	ignoreAcceptHeader(false).mediaTypes(mediaTypes).
    	defaultContentType(MediaType.APPLICATION_JSON);
    }

}
