package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "autore")

@NamedQueries({
	@NamedQuery(
	    name=Autore.NAMED_QUERY_ALL,
	    query="SELECT a FROM Autore a"
		),
@NamedQuery(
	    name=Autore.NAMED_QUERY_PER_RICERCA_BY_NOME,
	    query="SELECT a FROM Autore a where a.nome =:nome"
		),
})


@JsonIgnoreProperties(value = { "libri" })
public class Autore {
	
	public final static String NAMED_QUERY_ALL = "findAllAutori";
	public final static String NAMED_QUERY_PER_RICERCA_BY_NOME = "findAutoreByName";

	@Id
	@Column(name="id", nullable=false)
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;

	@Column(name="nome")
	private String nome;

	@Column(name="cognome")
	private String cognome;

	@OneToMany(mappedBy="autore",fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Libro> libri;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	
	public List<Libro> getLibri() {
		return libri;
	}

	public void setLibri(List<Libro> libri) {
		this.libri = libri;
	}
	
	
}
