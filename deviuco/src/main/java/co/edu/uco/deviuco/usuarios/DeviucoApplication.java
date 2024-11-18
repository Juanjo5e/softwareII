package co.edu.uco.deviuco.usuarios;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan(basePackages = {"co.edu.uco.deviuco.usuarios"})
@ComponentScan(basePackages = {"co.edu.uco.deviuco" })
@EnableJpaRepositories(basePackages = {"co.edu.uco.deviuco" })
public class DeviucoApplication  {

    public static void main(String[] args) {
        SpringApplication.run(DeviucoApplication.class, args);
    }
    
}