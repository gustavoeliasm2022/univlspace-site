package space.univl.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.microsoft.sqlserver.jdbc.SQLServerDriver;

public class SQLServerConnection {
	static {
		new SQLServerDriver();
	}
	public Connection getConnection() throws SQLException {
		return DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=CodigoRupestre", "SA", "CodigoRupestre11SpaceNative");
	}

}
