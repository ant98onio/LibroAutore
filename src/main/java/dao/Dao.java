package dao;

import java.util.List;

import javax.ejb.Local;

//@Stateless
//@PersistenceContext(name = "dynamic") https://tomee.apache.org/examples/dynamic-dao-implementation/
@Local
public interface Dao<T> {
	
	T get(int id);
	
	List <T> getAll();
	
	void save(T t);
	
	void update(T t, String [] params);
	
	void delete (T t);

}
