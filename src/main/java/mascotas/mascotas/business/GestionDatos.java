package mascotas.mascotas.business;


import java.util.List;

import mascotas.mascotas.dao.MascotaDAO;
import mascotas.mascotas.model.Mascota;

import jakarta.annotation.PostConstruct;
import jakarta.ejb.Singleton;
import jakarta.ejb.Startup;
import jakarta.inject.Inject;

@Singleton
@Startup
public class GestionDatos {
	
	@Inject
	private MascotaDAO daoMascota;
	
	
	/*@PostConstruct
	public void init() {
		System.out.println("INICIANDO PROGRAMA");
		
		Mascota mascota = new Mascota();
		mascota.setNombre("Zeus");
		mascota.setEspecie("Caninca");
		mascota.setRaza("Husky");
	
		daoMascota.insert(mascota);
        
        
	}
	*/
}
