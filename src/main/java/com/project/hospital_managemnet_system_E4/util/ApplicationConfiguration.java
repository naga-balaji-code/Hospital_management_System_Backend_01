
package com.project.hospital_managemnet_system_E4.util;

import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.info.License;

@Configuration
public class ApplicationConfiguration {

	@Bean
	public OpenAPI customOpenAPI() {
		return new OpenAPI().components(new Components()).info(new Info().title("Hospital Management System") // The
																												// title
																												// of
																												// the
																												// API.
				.description("Hospital Management System is a comprehensive platform for managing patient records, "
						+ "appointments, medical treatments, billing, and doctor-patient interactions. "
						+ "This system allows patients to book appointments, access medical histories, "
						+ "and manage prescriptions, while doctors can track patient progress, manage treatments, "
						+ "and handle administrative tasks like prescriptions and billing.")
				.version("1.0").contact(new Contact().name("Qspiders Team").email("qspiders@gmail.com"))
				.license(new License().name("License").url("#")));
	}

	@Bean
	public GroupedOpenApi publicApi() {
		return GroupedOpenApi.builder().group("public").packagesToScan("com.project.hospital_managemnet_system_E4")
				.build();
	}
}