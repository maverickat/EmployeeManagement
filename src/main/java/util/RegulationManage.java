package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Regulation;

public class RegulationManage {

	private Connection con;
	public RegulationManage() throws IOException {
		con = DbCon.getConnection();
	};
	
	public void deleteRugulation(String regulationid) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmnt = con.prepareStatement("DELETE FROM regulation WHERE regulationid = ?");
		stmnt.setString(1, regulationid);
		stmnt.executeUpdate();
	}

	public void createRegulation(Regulation regulation) throws SQLException {
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Regulation(regulationid,details,createdate,department) VALUES (?,?,?,?)");
		pstmt.setString(1,regulation.getRegulationid());
		pstmt.setString(2, regulation.getDetails());
		pstmt.setDate(3, new java.sql.Date(regulation.getCreateDate().getTime()));
		pstmt.setString(4, regulation.getDepartment());
		pstmt.executeUpdate();
	}
	public List<Regulation> getAllRegulation() throws SQLException{
		Statement stm = con.createStatement();
		List<Regulation> regulationlist = new ArrayList<Regulation>();
		String sql = "Select * from regulation;";
		ResultSet rs= stm.executeQuery(sql);
		while(rs.next()){
			Regulation regulation = new Regulation();
			regulation.setRegulationid(rs.getString("regulationid"));
			regulation.setDetails(rs.getString("details"));
			regulation.setCreateDate(rs.getDate("CreateDate"));
			regulation.setDepartment(rs.getString("department"));
			regulationlist.add(regulation);
		}
		return regulationlist;
	}

}
