package one.digitalinnovation.gof;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;

/**
 * Projeto Spring Boot gerado via Spring Initializr.
 * Os seguintes módulos foram selecionados:
 * - Spring Data JPA
 * - Spring Web
 * - H2 Database
 * - OpenFeign
 *
 * handleConstraintViolationExceptions
 *
 */
@EnableFeignClients
@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "API REST OPENAPI", version = "1.0", contact = @Contact(name = "Alice H.", email = "alicehata9@gmail.com", url = "https://github.com/Alice7H")))
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
