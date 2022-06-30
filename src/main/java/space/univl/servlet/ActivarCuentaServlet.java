package space.univl.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import space.univl.db.UsuarioDB;
@WebServlet("/activar")
public class ActivarCuentaServlet extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1879935538535987197L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("email");
		UsuarioDB usuarioDB = new UsuarioDB();
		usuarioDB.activarCuenta(email);
		req.setAttribute("respuesta", "Cuenta activada de forma exitosa");
		req.getRequestDispatcher("home.jsp").forward(req, resp);
	}
	

}
