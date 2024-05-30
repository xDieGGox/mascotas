package mascotas.mascotas.business;

import java.util.List;

import io.opentracing.Scope;
import io.opentracing.Span;
import io.opentracing.Tracer;
import io.opentracing.util.GlobalTracer;
import mascotas.mascotas.dao.MascotaDAO;
import mascotas.mascotas.model.Mascota;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class GestionMascotas{
	//implements GestionMascotasLocal,GestionMascotasRemoto
	
	@Inject
	private MascotaDAO daoMascota;
	
	private final Tracer tracer = GlobalTracer.get();
	
	public void guardarMascotas(Mascota mascota){
		
		Span span = tracer.buildSpan("guardarMascotas").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            Mascota cli = daoMascota.read(mascota.getCodigo_mascota());
            if (cli != null) {
                daoMascota.update(mascota);
            } else {
                daoMascota.insert(mascota);
            }
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
		
	}
	
	public void actualizarMascota(Mascota mascota) throws Exception {
		Mascota cli = daoMascota.read(mascota.getCodigo_mascota());
		if (cli != null){
			daoMascota.update(mascota);
		}else {
			throw new Exception("Mascota no existe");
		}
	}
	
	
	public void borrarMascota(int codigo) {
		
		daoMascota.remove(codigo); 
	}
	
	public List<Mascota> getMascotas(){
		return daoMascota.getAll();
	}
}
