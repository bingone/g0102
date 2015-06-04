package vo.OD;

import java.sql.Date;

public class voODError {
	private String errorNo;
	private String errorName;
	public String getErrorNo() {
		return errorNo;
	}
	public void setErrorNo(String errorNo) {
		this.errorNo = errorNo;
	}
	public String getErrorName() {
		return errorName;
	}
	public void setErrorName(String errorName) {
		this.errorName = errorName;
	}
	@Override
	public String toString() {
		return "voODError [errorNo=" + errorNo + ", errorName=" + errorName
				+ "]";
	}
	
	
}
