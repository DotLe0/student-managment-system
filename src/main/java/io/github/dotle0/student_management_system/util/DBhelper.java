package io.github.dotle0.student_management_system.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBhelper {
	final private static String jdbcUrl = "jdbc:sqlite:SMSDB.db";
	private static Connection connection;

	public static Connection getConnection() throws SQLException {

		connection = DriverManager.getConnection(jdbcUrl);
		return connection;
	}

	public static void closeConnection() throws SQLException {
		connection.close();
	}
}
