package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.User;

public class UserManage {
	private Connection con;
	public UserManage() throws IOException {
		con = DbCon.getConnection();
	};
	public boolean Login(User user) throws IOException, SQLException {
		
		Statement stm = con.createStatement();
		String sql = "SELECT * FROM user where userid=\""+user.getUserid()+"\"";
		ResultSet rs= stm.executeQuery(sql);
		if(rs.next()&&rs.getString("userid").equals(user.getUserid())&&rs.getString("password").equals(user.getPassword())) {
				user.setFname(rs.getString("fname"));
				user.setLname(rs.getString("lname"));
				user.setRole(rs.getString("role"));
				return true;
		}
		return false;
	}
	public void createUser(User user) throws SQLException{
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO User(fname,lname,email,phone,userid,password,role) VALUES (?,?,?,?,?,?,?)");
		pstmt.setString(1,user.getFname());
		pstmt.setString(2, user.getLname());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getUserid());
		pstmt.setString(6, user.getPassword());
		pstmt.setString(7, user.getRole());
		pstmt.executeUpdate();
	}
	public void UpdateUser(User user) throws SQLException{
		PreparedStatement pstmt = con.prepareStatement("Update INTO User(fname,lname,email,phone,userid,password,role) VALUES (?,?,?,?,?,?,?)");
		pstmt.setString(1,user.getFname());
		pstmt.setString(2, user.getLname());
		pstmt.setString(3, user.getEmail());
		pstmt.setString(4, user.getPhone());
		pstmt.setString(5, user.getUserid());
		pstmt.setString(6, user.getPassword());
		pstmt.setString(7, user.getRole());
		pstmt.executeUpdate();
	}
	public User getUser(String userid) throws SQLException {
		User user = new User();
		PreparedStatement stmnt = con.prepareStatement("SELECT * FROM User where userid=?");
		stmnt.setString(1,userid);
		ResultSet rs = stmnt.executeQuery();
		
		if(rs.next()){
			user.setUserid(rs.getString("userid"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setEmail(rs.getString("email"));
			user.setPhone(rs.getString("phone"));
			user.setUserid(rs.getString("userid"));
			user.setPassword(rs.getString("password"));
			user.setRole(rs.getString("role"));
			user.setDepartment(rs.getString("department"));
		}
		return user;
	}
	public void deleteUser(String userid) throws SQLException {
		PreparedStatement stmnt = con.prepareStatement("DELETE FROM user WHERE userid = ?");
		stmnt.setString(1, userid);
		stmnt.executeUpdate();
	}
	public List<User> getAllUsers() throws SQLException{
		Statement stm = con.createStatement();
		List<User> userList = new ArrayList<User>();
		String sql = "Select * from user;";
		ResultSet rs= stm.executeQuery(sql);
		while(rs.next()){
			User user = new User();
			user.setUserid(rs.getString("userid"));
			user.setFname(rs.getString("fname"));
			user.setLname(rs.getString("lname"));
			user.setEmail(rs.getString("email"));
			user.setPassword(rs.getString("password"));
			user.setPhone(rs.getString("phone"));
			user.setRole(rs.getString("role"));
			userList.add(user);
		}
		return userList;
	}
}
