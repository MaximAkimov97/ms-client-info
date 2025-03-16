package com.example.demo;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@OpenAPIDefinition(servers = {
		@Server(url = "${springdoc.swagger-ui.basePath}", description = "Default Server URL")
})
@SpringBootApplication
public class MsClientInfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(MsClientInfoApplication.class, args);
	}

}
