package br.com.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
			title = "API - Sistema Para Motoristas Por Aplicativo e Taxi.",
			version = "1.0",
			description = "API para auxiliar nas despesas de motoristas por aplicativo ou taxi.",
			contact = @Contact(name = "Carlos Roberto", email = "crrsj1@gmail.com")
		)
	)
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
