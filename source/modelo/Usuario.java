package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@NamedQuery(name = "mostrarTodosOsUsuarios", query = "select u from Usuario u")
public class Usuario {	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;	
	
	@Column(length=20, unique=true, nullable=false)
	private String login;
	
	@Temporal(TemporalType.DATE)
	private Date datacadastro;
	
	private List<String> nomeprods = new ArrayList<String>();

	public Usuario() {
		super();
	}

	public Usuario(String login) {
		super();
		this.login = login;
		this.datacadastro = new Date();
		this.nomeprods.add("Produto 1");
		this.nomeprods.add("Produto 2");				
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public Date getDatacadastro() {
		return this.datacadastro;
	}

	public void setDatacadastro(Date datacadastro) {
		this.datacadastro = datacadastro;
	}

	public List<String> getNomeprods() {
		return nomeprods;
	}

	public void setNomeprods(List<String> nomeprods) {
		this.nomeprods = nomeprods;
	}
	
	public void addProduto(String p) {
		this.nomeprods.add(p);
	}
	public void removeProduto(String p) {
		this.nomeprods.remove(p);
	}	
}
