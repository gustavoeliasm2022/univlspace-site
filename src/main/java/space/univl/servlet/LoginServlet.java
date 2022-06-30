package space.univl.servlet;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import space.univl.db.UsuarioDB;
import space.univl.encriptar.EncrypUtil;
import space.univl.model.Usuario;
@WebServlet("/login")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 8271853448569548495L;
	Logger log = Logger.getLogger(LoginServlet.class.getName());
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String email = req.getParameter("usuario");
		String password = req.getParameter("password");
//		System.out.println("Usuario: " + email);
//		System.out.println("Password: " + password);
		
		log.info("Usuario entrando a sistemas " + email);
		log.info("Password de usuario" + password);
		
		UsuarioDB usuarioDB =  new UsuarioDB();
		String respuesta = null;
		String pagina = null;
		
		Usuario usuario = usuarioDB.login(email);
		
		if (usuario == null) {
			respuesta = "Usuario no existe";
			pagina = "index.jsp";
		} else if (!usuario.isActivo()) {
			respuesta = "usuario no se encuentra activo, activar desde tu email";
			pagina = "index.jsp";
		}else if (! EncrypUtil.decode(usuario.getPassword()).equals(password)) {
			respuesta = "Password incorrecta";
			pagina = "index.jsp";
		}else {
			respuesta = "Acceso exitoso";
			req.setAttribute("usuario", usuario);
			HttpSession session = req.getSession();
			session.setAttribute("user", usuario);
			pagina = "home.jsp";
			
		}
		req.setAttribute("respuesta", respuesta);
		req.getRequestDispatcher(pagina).forward(req, resp);
	}
}
