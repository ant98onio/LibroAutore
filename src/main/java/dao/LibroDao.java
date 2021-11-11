package dao;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import model.Autore;
import model.Libro;

@Stateless
public class LibroDao {
	@Inject
	private AutoreDao autoreDao;

	@PersistenceContext(unitName = "persistenceUnit1") // tipo 'inject'
	private EntityManager em;

	public Autore get(int id) {
		return em.find(Autore.class, id);
	}

//	@Override
	public List<Libro> getAll() {
		return em.createNamedQuery("findAllLibri", Libro.class).getResultList();
	}

	public void inserisciLibro(Libro libro) throws Exception {

		if (get(libro.getId()) != null) {
			
			// cerco l'autore associato al libro che si vuole inserire 
			Autore a = autoreDao.get(libro.getAutore().getId());
			
			if (a == null)
				throw new Exception("il libro "+ libro.getTitolo()+" non esite l'autore");
			else 
				em.merge(libro);
		}else {
			em.persist(libro);
		}

	}

//@Override
	public void save(Libro l) {
		em.persist(l);
	}

//@Override
	public void update(Libro l) {//
		em.merge(l);
	}

//@Override
	public void delete(Libro l) {
		em.remove(l);
	}

}
