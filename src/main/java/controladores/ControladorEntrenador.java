package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Entrenador;

public class ControladorEntrenador {

	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("equipoCristina");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla personas
	public void borrarPersonas(Entrenador c) {
		this.em = entityManagerFactory.createEntityManager();
		Entrenador aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla personas
	public void modificarPersonas(Entrenador c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla personas
	public void crearPersonas(Entrenador c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codusuario
	public Entrenador findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Entrenador aux = null;
		this.consulta = em.createNativeQuery("Select * from entrenador where codentrenador = ?", Entrenador.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Entrenador) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}


	// Aparecen todos las personas que aparecen en la tabla personas
	public List<Entrenador> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Entrenador.findAll");
		List<Entrenador> lista = consulta.getResultList();
		this.em.close();
		return lista;
	}
}
