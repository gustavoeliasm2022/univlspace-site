package space.univl.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import space.univl.connection.SQLServerConnection;
import space.univl.encriptar.EncrypUtil;
import space.univl.model.Usuario;

public class UsuarioDB {

		private SQLServerConnection sqlServerConnection = new SQLServerConnection();
		public String crearUsuario(Usuario usuario) {
			String mensaje = "";
			try {
				Connection connection = sqlServerConnection.getConnection();
				String sqlInsert = "INSERT INTO USUARIOS (nombre, apellidoPaterno, apellidoMaterno, email, telefono, pais, password, activo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				PreparedStatement statement = connection.prepareStatement(sqlInsert);
				statement.setString(1, usuario.getNombre());
				statement.setString(2, usuario.getApellidoMaterno());
				statement.setString(3, usuario.getApellidoMaterno());
				statement.setString(4, usuario.getEmail());
				statement.setString(5, usuario.getTelefono());
				statement.setString(6, usuario.getPais());
				statement.setString(7, EncrypUtil.encode(usuario.getPassword()));
				statement.setBoolean(8, false);
				statement.executeUpdate();
				mensaje += "Usuaario creado de forma exitosa, se Activa via Email";
			} catch (SQLException e) {
				mensaje += e.getMessage();
				e.printStackTrace();
			}
			return mensaje;
			
		}
		
		public void activarCuenta(String email) {
			try {
				Connection connection = sqlServerConnection.getConnection();
				String sqlUpdate = "UPDATE USUARIOS SET activo = 1 WHERE email = '" + email + "'"; 
				Statement stmt = connection.createStatement();
				stmt.executeUpdate(sqlUpdate);
				System.out.println("Cuenta" + email + "Se activa de forma exitosa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		public Usuario login(String email) {
			Usuario usuario = null;
			try {
				Connection connection = sqlServerConnection.getConnection();
				String sqlSelect = "SELECT  nombre, apellidoPaterno, apellidoMaterno, email, telefono, pais, password, activo FROM USUARIOS WHERE email='"+ email + "'";
				Statement stSelect = connection.createStatement();
				ResultSet rs = stSelect.executeQuery(sqlSelect);
				while(rs.next()) {
					usuario = new Usuario();
					usuario.setNombre(rs.getString("nombre"));
					usuario.setApellidoPaterno(rs.getString("apellidoPaterno"));
					usuario.setApellidoMaterno(rs.getString("apellidoMaterno"));
					usuario.setEmail(rs.getString("email"));
					usuario.setTelefono(rs.getString("telefono"));
					usuario.setPais(rs.getString("pais"));
					usuario.setPassword(rs.getString("password"));
					usuario.setActivo(rs.getBoolean("activo"));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return usuario;
			
		}
}
