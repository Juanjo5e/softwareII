package co.edu.uco.deviuco.usuarios.application.primaryports.interactor;


import org.springframework.stereotype.Service;



@Service
public interface InteractorWithReturn <T, R>{
	R execute(T data);

	
}
