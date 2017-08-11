package io.egen.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).pathMapping("/api").apiInfo(apiInfo())
				.useDefaultResponseMessages(false);
	}

	private ApiInfo apiInfo() {
		Contact contact = new Contact("Revanth", "N/A", "N/A");
		return new ApiInfo("Weather Reporting", "Historical and current data for given city", "1.0", "TnC", contact,
				"N/A", "N/A");
	}
}
