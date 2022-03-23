package by.itstep.pronovich.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ConnectionUrl {
	private static final Logger log = LoggerFactory.getLogger(ConnectionUrl.class);
	public static final String URL = "jdbc:mysql://localhost:3306/Mobile_operator_tariffs?serverTimezone=Europe/Minsk";
	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			log.info("driver has been loaded");
		} catch (ClassNotFoundException e) {
			log.error("Class Not Found for loading driver", e);
		}
	}

	public static Connection getConnection() throws SQLException {
		return DriverManager.getConnection(URL, "root", "11111");
	}
}
