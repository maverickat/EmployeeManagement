package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Properties;

public class DbCon {
	private static Connection conn = null;
	public static Connection getConnection() throws IOException{
		
		ClassLoader loader = DbCon.class.getClassLoader();
		Properties props = new Properties();
		FileInputStream in = new FileInputStream(loader.getResource("db.properties").getPath());
		props.load(in);
		in.close();
				
		String driver = props.getProperty("driver");
		String url = props.getProperty("url");
		String username = props.getProperty("user");
		String password = props.getProperty("password");

		
		if(conn != null){
			return conn;
		}else{
			try {
				Class.forName(driver);			
				conn = DriverManager.getConnection(url, username, password);
				PreparedStatement s = conn.prepareStatement("Create Table if Not exists user(userid Varchar(20) primary key, password Varchar(20) NOT NULL,fname Varchar(20), lname varchar(20), email Varchar(20), phone Varchar(10),department Varchar(20) ,role Varchar(20)); ");
				s.execute();
				s = conn.prepareStatement("Create Table if Not exists regulation(regulationid Varchar(20) primary key,details Varchar(20),department Varchar(20) ,createDate DATE); ");
				s.execute();
				s = conn.prepareStatement("Create Table if Not exists comment(commentid Varchar(20) primary key,details Varchar(20),regulationid Varchar(20) ,createDate DATE,userid Varchar(20)) ; ");
				s.execute();
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}			
		}
		return conn;
	}
}
