package org.lazydoc.example.simple;

import org.lazydoc.example.simple.config.DispatcherConfig;
import org.lazydoc.example.simple.config.PersistenceConfig;
import org.lazydoc.example.simple.config.WebInitializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.embedded.EmbeddedServletContainerFactory;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;

@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = SimpleExampleApplication.PACKAGE_NAME)
@Import({ WebInitializer.class, DispatcherConfig.class, PersistenceConfig.class })
public class SimpleExampleApplication {

	public static final String PACKAGE_NAME = "org.lazydoc.example.simple";

	@Autowired
	private Environment env;

    @Bean
	public EmbeddedServletContainerFactory servletContainer() {
		TomcatEmbeddedServletContainerFactory factory = new TomcatEmbeddedServletContainerFactory();
		factory.setPort(9999);
		factory.setContextPath("/lazydoc-spring");
		return factory;
	}

	public static void main(String[] args) {
		SpringApplication.run(SimpleExampleApplication.class, args);
	}
}
