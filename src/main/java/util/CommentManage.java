package util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Comment;

public class CommentManage {

	private Connection con;
	public CommentManage() throws IOException {
		con = DbCon.getConnection();
	};
	
	public void deleteComment(String commentid) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement stmnt = con.prepareStatement("DELETE FROM comment WHERE commentid = ?");
		stmnt.setString(1, commentid);
		stmnt.executeUpdate();
	}

	public void createComment(Comment comment) throws SQLException {
		// TODO Auto-generated method stub
		PreparedStatement pstmt = con.prepareStatement("INSERT INTO Comment(regulationid,details,createdate,userid,commentid) VALUES (?,?,?,?,?)");
		pstmt.setString(1,comment.getRegulationid());
		pstmt.setString(2, comment.getDetails());
		pstmt.setDate(3, new java.sql.Date(comment.getCreateDate().getTime()));
		pstmt.setString(4, comment.getUserid());
		pstmt.setString(5, comment.getCommentid());
		pstmt.executeUpdate();
	}
	public List<Comment> getAllComment() throws SQLException{
		Statement stm = con.createStatement();
		List<Comment> commentlist = new ArrayList<Comment>();
		String sql = "Select * from Comment;";
		ResultSet rs= stm.executeQuery(sql);
		while(rs.next()){
			Comment comment = new Comment();
			comment.setRegulationid(rs.getString("regulationid"));
			comment.setDetails(rs.getString("details"));
			comment.setCreateDate(rs.getDate("CreateDate"));
			comment.setUserid(rs.getString("userid"));
			comment.setUserid(rs.getString("commentid"));
			commentlist.add(comment);
		}
		return commentlist;
	}
}
