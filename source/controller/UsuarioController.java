package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.Usuario;
import dao.DAOUsuario;

@WebServlet("/usu.do")
public class UsuarioController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public UsuarioController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		DAOUsuario udao = new DAOUsuario();
		// Quantidade que vem do banco
		int quantbanco = udao.quantidade();

		int pagina = 1;		
		if (request.getParameter("pagina") != null)
			pagina = Integer.parseInt(request.getParameter("pagina"));
		// Quantidade de valores por página
		int quant = 5;

		if (request.getParameter("quant") != null) {
			quant = Integer.parseInt(request.getParameter("quant"));
		}
		
		List<Usuario> lista = udao.listarUsuarios((pagina*quant)-quant, quant);
		
		
		// Formula usando a maior quantidade de páginas possível para amostragem dos valores. 
		// Divisão normal corta para baixo o integer.
		int numpaginas = (int) Math.ceil(quantbanco * 1.0/quant);
		
		request.setAttribute("lista", lista);
		request.setAttribute("numpaginas", numpaginas);
		request.setAttribute("quant", quant);
		request.setAttribute("pagina", pagina);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
}
