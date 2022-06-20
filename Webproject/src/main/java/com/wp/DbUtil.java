package com.wp;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static final String DB_URL="jdbc:mysql://localhost:3306/db3";
	public static final String USERNAME="root";
	public static final String PASSWORD="Naipunyam@23";
	public static Connection con=null;
	public static Connection dbconn() throws ClassNotFoundException, SQLException {
		//register the vendor driver 
		Class.forName("com.mysql.jdbc.Driver");
		
		//establish the connection
		con=DriverManager.getConnection(DB_URL,USERNAME,PASSWORD);
		
		return con;
	}
}
