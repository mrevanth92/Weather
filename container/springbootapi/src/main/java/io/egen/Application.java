package io.egen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import io.egen.config.SwaggerConfig;
import io.egen.config.WebConfig;

@SpringBootApplication
@Import({WebConfig.class, SwaggerConfig.class})
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
