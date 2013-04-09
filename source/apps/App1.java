package apps;

import modelo.Usuario;
import dao.DAOUsuario;

public class App1 {

	public static void main(String[] args) {
		DAOUsuario udao = new DAOUsuario();
		
		udao.begin();
		
		udao.persist(new Usuario("Vinicius"));
		udao.persist(new Usuario("Paulo"));
		udao.persist(new Usuario("Pedro"));
		udao.persist(new Usuario("Thiago"));
		udao.persist(new Usuario("Arthur"));
		udao.persist(new Usuario("Venceslau"));
		udao.persist(new Usuario("Ginga"));
		udao.persist(new Usuario("Marcos"));
		udao.persist(new Usuario("Joao"));
		udao.persist(new Usuario("Moura"));
		udao.persist(new Usuario("Victor"));
		udao.persist(new Usuario("Felipe"));
		udao.persist(new Usuario("Alex"));
		udao.persist(new Usuario("Sandro"));
		udao.persist(new Usuario("Silva"));
		udao.persist(new Usuario("etc"));
		udao.commit();
		udao.close();
	}
}
