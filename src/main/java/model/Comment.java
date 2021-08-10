package model;

import java.util.Date;

public class Comment {
	private String commentid;
	private String userid;
	private String regulationid;
	private String details;
	private Date createDate;
	
	public Comment() {
	};
	
	public String getCommentid() {
		return commentid;
	}
	public void setCommentid(String commentid) {
		this.commentid = commentid;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getRegulationid() {
		return regulationid;
	}
	public void setRegulationid(String regulationid) {
		this.regulationid = regulationid;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
}
