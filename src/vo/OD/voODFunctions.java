package vo.OD;

import java.sql.Date;

public class voODFunctions {
	private String functionNo;
	private String description;
	private Date   createDate;
	public String getFunctionNo() {
		return functionNo;
	}
	public void setFunctionNo(String functionNo) {
		this.functionNo = functionNo;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "voODFunctions [functionNo=" + functionNo + ", description="
				+ description + ", createDate=" + createDate + "]";
	}
	
}
