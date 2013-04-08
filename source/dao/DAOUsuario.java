package dao;

import java.util.List;

import javax.persistence.Query;

import modelo.Usuario;

public class DAOUsuario extends DAOJPA<Usuario> {
	public DAOUsuario() {
		super();
	}
	// consultas
	@SuppressWarnings("unchecked")
	public List<Usuario> listarUsuarios(int inicio, int quant) {
		Query q  = getManager().createNamedQuery("mostrarTodosOsUsuarios").setFirstResult(inicio).setMaxResults(quant);
		return q.getResultList();
	}
	public int quantidade() {
		return super.findAll().size();
	}
}
