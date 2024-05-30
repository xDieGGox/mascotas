package mascotas.mascotas.dao;

import java.util.List;

import mascotas.mascotas.model.Mascota;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless
public class MascotaDAO {

	@PersistenceContext
	private EntityManager em;
	
	public void insert(Mascota mascota) {
		em.persist(mascota);
		
	}
	
	public void update(Mascota mascota) {
		em.merge(mascota);
			
	}
	
	public void remove(int codigo) {
		Mascota mascota = em.find(Mascota.class, codigo);
		em.remove(mascota);
		
	}
	
	public Mascota read (int codigo) {
		Mascota mascota = em.find(Mascota.class, codigo);
		
		return mascota;
		
	}
	
	public List<Mascota> getAll(){
		String jpql = "SELECT m FROM Mascota m";//Aqui nos referimos a las entidades no a la base de daros, es sensible a mayuscular y minusculas
		Query q = em.createQuery(jpql, Mascota.class);
		return q.getResultList();
	}
	
}
