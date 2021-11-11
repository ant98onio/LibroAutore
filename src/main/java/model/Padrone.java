package model;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "padrone")

@NamedQueries({
	@NamedQuery(
		    name="findAllOwners",
		    query="SELECT p FROM Padrone p"
		), //HQL >> for hibernate
})
public class Padrone implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "padrone_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	@Column(name = "nome")
	private String nome;
	
	@Column(name = "cognome")
	private String cognome;
	
	/*
	@OneToMany(fetch = FetchType.LAZY,  mappedBy="padrone") //nome che mappa l'entita'
	@Transient
	private List<Cane> cani;
	
	@ManyToMany (mappedBy = "padroneOfGatto")
	private Set<Gatto> gatto; //to insert in postgres
	*/

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public String toString() {
		return "Persona [id=" + id + ", nome=" + nome +
				", cognome=" + cognome +"]";
	}

}
