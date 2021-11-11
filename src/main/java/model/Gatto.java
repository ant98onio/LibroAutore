package model;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

//to insert in postgres
@Entity
@Table(name = "gatto")
@NamedQuery(
	    name="findAllGatti",
	    query="SELECT g FROM Gatto g"
	)
public class Gatto {
	
	@Id
	@Column(name = "gatto_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int gattoId;

	@Column(name = "nome")
	private String nome;
	
	@Column(name = "razza")
	private String razza;
	
	@ManyToMany
	@JoinTable(
			name = "ownerships",
			joinColumns = @JoinColumn(name = "gatto_id"),
			inverseJoinColumns = @JoinColumn(name = "padrone_id")
			)
	private Set<Padrone> padroneOfGatto;
	
	
	public int getGattoId() {
		return gattoId;
	}

	public void setGattoId(int gattoId) {
		this.gattoId = gattoId;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRazza() {
		return razza;
	}

	public void setRazza(String razza) {
		this.razza = razza;
	}
}
