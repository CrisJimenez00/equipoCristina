package controladores;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;

import entidades.Jugador;

public class ControladorJugador {
	private static EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("equipoCristina");
	private EntityManager em;
	private Query consulta;

	// Borra elementos de la tabla jugador
	public void borrarJugador(Jugador c) {
		this.em = entityManagerFactory.createEntityManager();
		Jugador aux = null;
		this.em.getTransaction().begin();
		if (!this.em.contains(c)) {
			aux = this.em.merge(c);
		}
		this.em.remove(aux);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Modifica elementos de la tabla jugador
	public void modificarJugador(Jugador c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.merge(c);
		this.em.getTransaction().commit();
		this.em.close();

	}

	// Crea un elemento en la tabla jugador
	public void crearJugador(Jugador c) {
		this.em = entityManagerFactory.createEntityManager();
		this.em.getTransaction().begin();
		this.em.persist(c);
		this.em.getTransaction().commit();
		this.em.close();
	}

	// Busca por primary key en este caso codjugador
	public Jugador findByPK(int pk) {
		this.em = entityManagerFactory.createEntityManager();
		Jugador aux = null;
		this.consulta = em.createNativeQuery("Select * from jugador where codjugador = ?", Jugador.class);
		this.consulta.setParameter(1, pk);

		try {
			aux = (Jugador) consulta.getSingleResult();
		} catch (NoResultException nre) {
			aux = null;
		}

		this.em.close();
		return aux;

	}

	// Busca por DNI
//	public Personas findByDni(String dni) {
//		this.em = entityManagerFactory.createEntityManager();
//		Personas aux = null;
//		this.consulta = em.createNativeQuery("Select * from personas where dni = ?", Personas.class);
//		this.consulta.setParameter(1, dni);
//		try {
//			aux = (Personas) consulta.getSingleResult();
//		} catch (NoResultException nre) {
//			aux = null;
//		}
//		this.em.close();
//		return aux;
//
//	}

	// Aparecen todos las personas que aparecen en la tabla jugador
	public List<Jugador> findAll() {
		this.em = entityManagerFactory.createEntityManager();
		this.consulta = em.createNamedQuery("Jugador.findAll");
		List<Jugador> lista = consulta.getResultList();
		this.em.close();
		return lista;
	}

}
