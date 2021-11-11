package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;


@Stateless
public class AutoreDao {
	
	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;
	
	public Autore get(int id) {
		return em.find(Autore.class, id);
	}

	//@Override
	public List<Autore> getAll() {
		return em.createNamedQuery(Autore.NAMED_QUERY_ALL, Autore.class)
				.getResultList();
	}
	
	public List<Autore> getAutoreByName(String name) {
		return em.createNamedQuery(Autore.NAMED_QUERY_PER_RICERCA_BY_NOME, Autore.class)
				.setParameter("nome", name)
				.getResultList();
	}
	
	public void inserisciAutore(Autore autore) {
		Autore autoreEsistente = em.find(Autore.class, autore.getId());
		if (autoreEsistente != null) {
			autoreEsistente.setNome(autore.getNome());
			autoreEsistente.setCognome(autore.getCognome());
			em.merge(autoreEsistente);
		}else {
			em.persist(autore);
		}
	}

//	@Override
	public void save(Autore a) {
		em.persist(a);
	}

//	@Override
	public void update(Autore a) {//
		em.merge(a);
	}

//	@Override
	public void delete(Autore a) {
		em.remove(a);
	}

}
