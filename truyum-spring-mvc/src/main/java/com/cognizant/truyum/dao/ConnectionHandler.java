package com.cognizant.truyum.dao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionHandler {
	static Connection getConnection() throws IOException, SQLException, ClassNotFoundException {
		FileInputStream name = new FileInputStream("connection.properties");
		Properties obj = new Properties();
		obj.load(name);
		Class.forName(obj.getProperty("driver"));
		Connection connec = DriverManager.getConnection(obj.getProperty("connection-url"), obj.getProperty("user"),
				obj.getProperty("password"));

		return connec;

	}

}
