package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;



public class DB {
	
	// instancia um objeto do tipo Connection
	private static Connection conn = null;
	//caso não haja conexão, o metodo irá conectar;
	public static Connection getConnection() {
		if (conn == null) {
			try {
				Properties props = loadProperties();
				String url = props.getProperty("dburl");
				conn = DriverManager.getConnection(url, props);
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
			
		}
		return conn;
	}
	// metodo para fechar a conexão
	public static void closeConnection() {
		if (conn != null) {
			try {
				conn.close();
			}
			catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	//metodo para carregar os dados da conexão;
	private static Properties loadProperties() {
		try(FileInputStream fs = new FileInputStream("db.properties")) {//file na raiz projeto
			Properties props = new Properties();
			props.load(fs);
			return props;
		}
		catch (IOException e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	public static void closeStatement(Statement st) {
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}
	
	public static void closeResultSet(ResultSet rs) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				throw new DbException(e.getMessage());
			}
		}
	}

}
