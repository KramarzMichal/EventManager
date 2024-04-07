package pl.event.manager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		System.out.println("http://localhost:8080/swagger-ui/index.html");
		System.out.println("http://localhost:8080/v3/api-docs");
		SpringApplication.run(Application.class, args);
	}

}
