package com.dziedzic.warehouse;
/*
 * @project margo-server
 * @author Łukasz Dziedzic
 * @date 12.02.2020
 */
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(MargoServerApplication.class);
	}

}
