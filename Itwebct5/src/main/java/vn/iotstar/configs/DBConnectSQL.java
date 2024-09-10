package vn.iotstar.configs;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectSQL {

	private final String serverName = "localhost";
	private final String dbName = "ltwebct5";
	private final String portNumber = "1433";
	private final String instance = "";

	public Connection getConnection() {
		Connection conn = null;

		try {
			String url = "jbbc:sqlserver://" + serverName + ":" + portNumber + "\\" + instance + ";databaseName="
					+ dbName;

			if (instance == null || instance.trim().isEmpty())
				url = "jbbc:sqlserver://" + serverName + ":" + portNumber + ";databaseName=" + dbName;
			conn = DriverManager.getConnection(url);

			if (conn != null) {
				DatabaseMetaData dm = (DatabaseMetaData) conn.getMetaData();
				System.out.println("Driver name: " + dm.getDriverName());
				System.out.println("Driver version: " + dm.getDriverVersion());
				System.out.println("Product Name: " + dm.getDatabaseProductName());
				System.out.println("Product version: " + dm.getDatabaseProductVersion());

				return conn;
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return null;
	}

	public static void main(String[] args) {
		try {
			
			System.out.print(new DBConnectSQL().getConnection());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}