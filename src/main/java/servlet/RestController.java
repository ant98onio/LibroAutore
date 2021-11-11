package servlet;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.AutoreDao;
import dao.LibroDao;
import model.Libro;
import model.Autore;

@Stateless

@Path("rest")
public class RestController {

	@Inject
	private LibroDao libroDao;

	@Inject
	private AutoreDao autoreDao;
	
	// --- http://localhost:8080/libroAutore/api/rest/all ---
	// http protocollo
	// 127.0.0.1 : dove risiede il mio server
	// 8080 porta default di esposizione protocollo application server
	// libroAutore = nome progetto definito in maven
	// api = servlet
	// rest = ejb contenitore di servizi esposti
	// all = il nome del metodo
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("{id}") //variabile {}
	public Autore getById(@PathParam("id") int id) {
		return autoreDao.get(id);
	}	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("/getByName/{nome}") //variabile {}
	public List<Autore> getAuthorByName(@PathParam("nome") String nome) {
		return autoreDao.getAutoreByName(nome);
	}

	//metodo per tornare tutti gli autori 
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("allAuthor") //variabile {}
	public List<Autore> getEvryone() {
		return autoreDao.getAll();
	}

	//metodo per tornare tutti i libri 
	@GET
	@Produces(MediaType.APPLICATION_JSON) //formato di dato
	@Path("allBooks") //variabile {}
	public List<Libro> getAllBooks() {
		return libroDao.getAll();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("insertAutore")
	public Autore inserisciAutore(Autore a) {
		autoreDao.inserisciAutore(a);
		return a;
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("insertLibro")
	public Libro inserisciLibro(Libro l) throws Exception {
		libroDao.inserisciLibro(l);
		return l;
	}


}
