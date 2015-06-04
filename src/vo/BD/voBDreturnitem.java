package vo.BD;

import java.sql.Date;

public class voBDreturnitem {
	public String returnNo;
	public String contractNo;
	public Date ruturndate;
	public String returnReason;
	public String returnStatus;
	public String getReturnNo() {
		return returnNo;
	}
	public void setReturnNo(String returnNo) {
		this.returnNo = returnNo;
	}
	public String getContractNo() {
		return contractNo;
	}
	public void setContractNo(String contractNo) {
		this.contractNo = contractNo;
	}
	public Date getRuturndate() {
		return ruturndate;
	}
	public void setRuturndate(Date ruturndate) {
		this.ruturndate = ruturndate;
	}
	public String getReturnReason() {
		return returnReason;
	}
	public void setReturnReason(String returnReason) {
		this.returnReason = returnReason;
	}
	public String getReturnStatus() {
		return returnStatus;
	}
	public void setReturnStatus(String returnStatus) {
		this.returnStatus = returnStatus;
	}
	
}
