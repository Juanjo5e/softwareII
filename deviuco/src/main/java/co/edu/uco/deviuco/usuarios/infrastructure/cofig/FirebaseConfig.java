package co.edu.uco.deviuco.usuarios.infrastructure.cofig;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import org.springframework.context.annotation.Configuration;
import javax.annotation.PostConstruct;
import java.io.FileInputStream;
import java.io.IOException;

@Configuration
public class FirebaseConfig {

    @PostConstruct
    public void initializeFirebase() {
        try {
            // Ruta del archivo JSON con las credenciales de Firebase
            FileInputStream serviceAccount = new FileInputStream("/deviuco/src/main/resources/deviucopay-69f54-firebase-adminsdk-hf3s0-77b49002bd.json");

            // Configurar las opciones de Firebase con las credenciales
            FirebaseOptions options = FirebaseOptions.builder()
                    .setCredentials(GoogleCredentials.fromStream(serviceAccount))
                    .build();

            // Inicializar Firebase si aún no está inicializado
            if (FirebaseApp.getApps().isEmpty()) {
                FirebaseApp.initializeApp(options);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}