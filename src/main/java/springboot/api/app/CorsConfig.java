package springboot.api.app;

import java.lang.reflect.Method;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {
	
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
		@Override	
		public void addCorsMappings(CorsRegistry registry ) {
			registry.addMapping("/login")
			.allowedOriginPatterns("http://localhost:4200")
			.allowedMethods("POST")
			.exposedHeaders("*")
			.allowedHeaders("*");
			
			registry.addMapping("/persona/**")
			.allowedOriginPatterns("http://localhost:4200")
			.allowedMethods("*")
			.exposedHeaders("*");
			

			registry.addMapping("/nota/**")
			.allowedOriginPatterns("http://localhost:4200")
			.allowedMethods("*")
			.exposedHeaders("*");
		}
		};
	}
}
