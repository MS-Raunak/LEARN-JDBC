package com.ms.jdbc.my_jdbc.preparedStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App1 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		String driver_url = "com.mysql.cj.jdbc.Driver";
		String db_url = "jdbc:mysql://localhost:3306/jdbc";

		// Step-1: Registering the Driver
		Class.forName(driver_url);

		// Step-2: Establishing the Connection
		Connection con = DriverManager.getConnection(db_url, "root", "tiger");

		// Step-3: Creating Statement(PreparedStatement)
		PreparedStatement ps = con.prepareStatement("INSERT INTO EMPLOYEE(ID,NAME,AGE) VALUES(?,?,?)");

		ps.setInt(1, 4);
		ps.setString(2, "Gita");
		ps.setInt(3, 23);

		// Step-4: Executing the Query
		/*
		 * try { ps.execute(); System.out.println("Data inserted successfully"); } catch
		 * (Exception e) {
		 * System.out.println("Something error occured: data not inserted.."); }
		 */

		// Step-5: Processing the Result
		PreparedStatement ps_result = con.prepareStatement("SELECT * FROM EMPLOYEE WHERE ID=?");
		ps_result.setInt(1, 2);

		ResultSet rs = ps_result.executeQuery();
		
		while (rs.next()) {
			System.out.println("ID: " + rs.getInt(1) + "\t Name: " + rs.getString(2) + "\t Age: " + rs.getInt(3));
			System.out.println("=================================================");
		}

		// Step-5: Close the Connection
		con.close();

	}

}
