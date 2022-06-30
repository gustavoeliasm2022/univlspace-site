package space.univl.servlet;

import java.io.IOException;

import javax.mail.Session;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import space.univl.model.Usuario;
@WebServlet("/pedidosCliente")
public class PedidosClientesServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1878754922832072524L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		HttpSession session = req.getSession(false);
		if(session != null) {
			Usuario usuario = (Usuario) session.getAttribute("user");
			if(usuario != null) {
				System.out.println("Usuario: " + usuario.getNombreCompleto());
				req.setAttribute("mensaje", "Mostrar pedisos de: " + usuario.getNombreCompleto());
			}else {
				req.setAttribute("mensaje", "Logearse primero por favor");
			}
//			}
			
			System.out.println("");
			
		} else {
			req.setAttribute("mensaje", "Logearse primero por favor");
		}
		req.getRequestDispatcher("pedidosCliente.jsp").forward(req, resp);
	}
}
