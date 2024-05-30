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
		Span span = tracer.buildSpan("actualizarMascota").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            Mascota cli = daoMascota.read(mascota.getCodigo_mascota());
            if (cli != null) {
                daoMascota.update(mascota);
            } else {
                throw new Exception("Mascota no existe");
            }
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}
	
	
	public void borrarMascota(int codigo) {
		
		Span span = tracer.buildSpan("borrarMascota").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            daoMascota.remove(codigo);
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}
	
	public List<Mascota> getMascotas(){
		Span span = tracer.buildSpan("getMascotas").start();
        try (Scope scope = tracer.scopeManager().activate(span)) {
            return daoMascota.getAll();
        } catch (Exception e) {
            span.log(e.getMessage());
            throw e;
        } finally {
            span.finish();
        }
	}
}
