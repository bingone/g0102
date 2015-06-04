package vo.OD;

import java.sql.Date;

public class voODPermissions {
	private String userNo;
	private String functionNo;
	private Date   createDate;
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getFunctionNo() {
		return functionNo;
	}
	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "voODPermissions [userNo=" + userNo + ", functionNo="
				+ functionNo + ", createDate=" + createDate + "]";
	} 
	
}
