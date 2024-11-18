package co.edu.uco.deviuco.usuarios;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**") // Permite todas las rutas
                .allowedOrigins("https://localhost:5173") // Cambia esto al origen de tu frontend
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Métodos permitidos
                .allowedHeaders("*") // Permite todos los encabezados
                .allowCredentials(true); // Permite el uso de credenciales
    }
}